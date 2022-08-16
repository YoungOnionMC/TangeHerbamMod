package tangeherbam.common.EventHandlers;

import net.dries007.tfc.util.calendar.CalendarTFC;
import net.dries007.tfc.util.calendar.ICalendar;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import ru.aiefu.timeandwindct.ITimeOperations;
import ru.aiefu.timeandwindct.TimeAndWindCT;
import ru.aiefu.timeandwindct.TimeTicker;
import sun.util.resources.cldr.aa.CalendarData_aa_ER;

import java.util.Arrays;

import static tangeherbam.THValues.*;

@Mod.EventBusSubscriber(modid = MODID)
public class CalendarEvent {

    private static float dayLength, nightLength;
    private static boolean set = false;
    private static final float minHours = 7.88f, maxHours = 16.12f;

    private static final float amplitude = (maxHours - minHours) / 2f;
    private static final float average = (maxHours + minHours) / 2f;
    private static final float daysInYear = CalendarTFC.CALENDAR_TIME.getDaysInMonth() * 12;
    private static final float period = ((float)(2*Math.PI)/daysInYear);

    @SubscribeEvent
    public static void onOverworldTick(TickEvent.WorldTickEvent event) {
        if(event.phase == TickEvent.Phase.END && event.world.provider.getDimension() == 0) {
            if(Loader.isModLoaded("tawct")) {
                if(event.world.getWorldTime() % (ICalendar.TICKS_IN_DAY / ICalendar.TICK_MULTIPLIER) > 3000 && event.world.getWorldTime() % (ICalendar.TICKS_IN_DAY / ICalendar.TICK_MULTIPLIER) < 8000 && !set) {
                    set = true;
                    int dayOfMonth = CalendarTFC.CALENDAR_TIME.getDayOfMonth();
                    int monthOfYear = CalendarTFC.CALENDAR_TIME.getMonthOfYear().ordinal();

                    int dayOfYear = monthOfYear * (int)CalendarTFC.CALENDAR_TIME.getDaysInMonth() + dayOfMonth;

                    dayLength = (float)Math.max(Math.min(
                            amplitude * Math.sin(period * (dayOfYear - 37)) + average,
                            maxHours), minHours) * ICalendar.TICKS_IN_HOUR;
                    Arrays.stream(DimensionManager.getWorlds()).forEach(serverWorld -> {
                        String id = serverWorld.provider.getDimensionType().getName();
                        if (TimeAndWindCT.timeDataMap.containsKey(id)) {
                            ((ITimeOperations) serverWorld).getTimeTicker().setupCustomTime((int)dayLength, ICalendar.TICKS_IN_DAY - (int)dayLength);
                        }
                    });
                }
                if(event.world.getWorldTime() % (ICalendar.TICKS_IN_DAY / ICalendar.TICK_MULTIPLIER) > 8001 && set)
                    set = false;
            }
        }
    }
}
