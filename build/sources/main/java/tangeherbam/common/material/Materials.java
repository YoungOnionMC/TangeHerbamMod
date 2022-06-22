package tangeherbam.common.material;


import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.crafttweaker.CTMaterialBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Material.Builder;

public class Materials {

    // Ores/Minerals
    public static Material Argentite;
    public static Material Polybasite;
    public static Material Proustite;

    public static void registerMaterials() {
        Argentite = new Material.Builder(25600, "argentite")
                .gem()
                .components(Silver, 2, Sulfur, 1)
                .build();
        Polybasite = new Material.Builder(25601, "polybasite")
                .gem()
                .components(Silver, 6, Copper, 6, Stibnite, 2, Arsenic, 2, Sulfur, 7, Silver, 9, Copper, 1, Sulfur, 4)
                .build();
        Proustite = new Material.Builder(25602, "proustite")
                .gem()
                .components(Silver, 3, Arsenic, 1, Sulfur, 3).build();
    }




}
