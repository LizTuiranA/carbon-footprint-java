# Guia de sustentacion en video

## 1. Presentacion del problema

"En esta actividad desarrolle un proyecto en Java para calcular huella de carbono siguiendo el caso de estudio de Deitel. El reto principal fue modelar Building, Car y Bicycle como clases no relacionadas por herencia, pero con un comportamiento comun."

## 2. Explicacion del diseno

"Primero hice analisis del problema e identifique entidades, atributos y formulas. Luego defini una interfaz `CarbonFootprint` como contrato comun para asegurar coherencia y extensibilidad."

## 3. Explicacion de cada clase

- `Building`: calcula huella con electricidad y gas.
- `Car`: calcula huella con kilometros anuales y eficiencia de combustible.
- `Bicycle`: retorna 0 si es convencional y calcula consumo electrico si es electrica.
- `CarbonFootprintFileManager`: guarda resultados en archivo de texto.
- `Main`: crea objetos, aplica polimorfismo y coordina la ejecucion.

## 4. Explicacion de la interfaz

"La interfaz `CarbonFootprint` define dos metodos: `getCarbonFootprint` y `getDescription`. Asi garantizo que cualquier nueva clase (por ejemplo, Bus o Motorcycle) pueda integrarse sin alterar la logica central."

## 5. Explicacion del polimorfismo

"Uso `ArrayList<CarbonFootprint>` para almacenar objetos heterogeneos. En el recorrido for-each, Java invoca la implementacion correspondiente de cada clase de forma polimorfica."

## 6. Explicacion del archivo TXT generado

"El programa genera `data/carbon_footprint_results.txt` con descripcion y huella anual por objeto. Se usa `try-with-resources` para manejo seguro de recursos y captura de `IOException`."

## 7. Explicacion de las pruebas unitarias

"Implemente JUnit 5 para validar:
1) calculos de huella,
2) contenido de descripciones,
3) creacion y contenido del archivo de salida.
Todas se ejecutan con `mvn test`."

## 8. Cierre segun rubrica

"Con este proyecto cumplo la rubrica porque: realice analisis y diseno, implemente POO con interfaz y polimorfismo, aplique principios SOLID basicos, documente el desarrollo y valide funcionalidad con pruebas unitarias y evidencia de ejecucion." 
