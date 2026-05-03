# Analisis y diseno del proyecto Carbon Footprint

## 1. Analisis del problema

El problema solicita modelar distintos objetos con huella de carbono sin relacionarlos por herencia. Building, Car y Bicycle tienen formulas y datos diferentes, por lo que se requiere una abstraccion comun para tratarlos de forma uniforme sin forzar una jerarquia artificial.

## 2. Clases identificadas

- `CarbonFootprint` (interfaz)
- `Building`
- `Car`
- `Bicycle`
- `CarbonFootprintFileManager`
- `Main`

## 3. Atributos por clase

- `Building`
  - `name`
  - `annualElectricityKwh`
  - `annualNaturalGasM3`

- `Car`
  - `brand`
  - `model`
  - `annualKilometers`
  - `fuelEfficiencyKmPerLiter`

- `Bicycle`
  - `brand`
  - `type`
  - `annualKilometers`
  - `electric`

## 4. Metodos por clase

- `CarbonFootprint`
  - `double getCarbonFootprint()`
  - `String getDescription()`

- `Building`
  - Constructor
  - Getters
  - `getCarbonFootprint()`
  - `getDescription()`

- `Car`
  - Constructor
  - Getters
  - `getCarbonFootprint()`
  - `getDescription()`

- `Bicycle`
  - Constructor
  - Getters
  - `getCarbonFootprint()`
  - `getDescription()`

- `CarbonFootprintFileManager`
  - `saveResults(List<CarbonFootprint> items, Path outputPath)`

- `Main`
  - `main(String[] args)`

## 5. Diseno UML textual

```text
<<interface>> CarbonFootprint
+ getCarbonFootprint(): double
+ getDescription(): String

Building implements CarbonFootprint
- name: String
- annualElectricityKwh: double
- annualNaturalGasM3: double
+ getCarbonFootprint(): double
+ getDescription(): String

Car implements CarbonFootprint
- brand: String
- model: String
- annualKilometers: double
- fuelEfficiencyKmPerLiter: double
+ getCarbonFootprint(): double
+ getDescription(): String

Bicycle implements CarbonFootprint
- brand: String
- type: String
- annualKilometers: double
- electric: boolean
+ getCarbonFootprint(): double
+ getDescription(): String

CarbonFootprintFileManager
+ saveResults(items: List<CarbonFootprint>, outputPath: Path): void

Main
+ main(args: String[]): void
```

## 6. Por que interfaz y no herencia entre Building, Car y Bicycle

No existe una relacion "es-un" coherente entre Building, Car y Bicycle. Forzar herencia crearia acoplamiento innecesario y una jerarquia incorrecta. La interfaz `CarbonFootprint` define solo el comportamiento comun requerido por el caso, respetando independencia entre clases.

## 7. Polimorfismo en ArrayList<CarbonFootprint>

En `Main`, los objetos se almacenan en `List<CarbonFootprint>`. Al recorrer la lista, cada objeto ejecuta su propia implementacion de `getCarbonFootprint()` y `getDescription()`. Esto demuestra despacho dinamico y simplifica extension futura.

## 8. Manejo de archivos

`CarbonFootprintFileManager` centraliza la escritura del reporte en `data/carbon_footprint_results.txt`. Se usa `try-with-resources` para cerrar el escritor automaticamente, `Files.createDirectories` para asegurar la carpeta y manejo de `IOException` para robustez.

## 9. Pruebas unitarias

Se implementan pruebas JUnit 5 para:
- Validar calculos de Building, Car y Bicycle.
- Validar descripciones no vacias o con datos esperados.
- Validar creacion de archivo y contenido no vacio en `CarbonFootprintFileManager`.

## 10. Relacion con criterios de desempeno

1. Analisis y diseno: documento con clases, metodos, atributos y UML textual.
2. Desarrollo con POO y SOLID: interfaz, polimorfismo y responsabilidades separadas.
3. Documentacion y pruebas: README, analisis, guia de video y JUnit 5 ejecutable con Maven.
4. Sustentacion: guion de exposicion en `docs/guia_video.md` alineado con rubrica.
