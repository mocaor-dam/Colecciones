package ejercicio7;

import exceptions.RecetaException;

public class Main {
    static void main(String[] args) {
        Recetario recetario = new Recetario();
        try {
            Ingrediente huevo = new Ingrediente("Huevo", 2);
            Ingrediente papa = new Ingrediente("Papa", 3);

            Ingrediente lechuga = new Ingrediente("Lechuga", 3);
            Ingrediente tomate = new Ingrediente("Tomate", 2);
            Ingrediente huevo2 = new Ingrediente("Huevo", 2);


            Receta tortillaPapa = new Receta("Tortilla de patatas", 5);
            Receta ensalada = new Receta("Ensalada", 10);



            tortillaPapa.addIngrediente(huevo);
            tortillaPapa.addIngrediente(papa);
            ensalada.addIngrediente(lechuga);
            ensalada.addIngrediente(tomate);
            ensalada.addIngrediente(huevo2);



            tortillaPapa.addPaso("Pelar las papas");
            tortillaPapa.addPaso("Freir las papas");
            ensalada.addPaso("Cortar la lechuga");
            ensalada.addPaso("Cortar el tomate");


            recetario.addReceta(tortillaPapa);
            recetario.addReceta(ensalada);

            System.out.println("Listado por orden alfabetico");
            System.out.println(recetario.listadoRecetasOrdenadasAlfabeticamente());

            System.out.println("Listado por tiempo");
            System.out.println(recetario.listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion("Huevo"));


            System.out.println("Borrando el Huevo de la Tortilla");
            tortillaPapa.borrarIngrediente(new Ingrediente("Huevo", 0));


        } catch (RecetaException e){
            System.out.println(e.getMessage());
        }

    }
}
