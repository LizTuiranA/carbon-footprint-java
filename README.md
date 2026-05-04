# Carbon Footprint Java

Proyecto academico en Java y Maven para el caso de estudio de Deitel, donde clases no relacionadas por herencia (Building, Car y Bicycle) implementan una interfaz comun llamada CarbonFootprint para calcular su huella de carbono.

## Caso de estudio

Se modelan tres tipos de objetos del mundo real que generan impacto ambiental de formas distintas:
- Building por consumo de electricidad y gas natural.
- Car por consumo anual de combustible.
- Bicycle con dos escenarios: convencional (0) y electrica (consumo de energia).

La integracion se hace mediante una interfaz compartida para habilitar polimorfismo y cumplir el enunciado de clases no relacionadas entre si por herencia.

## Conceptos aplicados

- Interfaz: `CarbonFootprint` define el contrato comun (`getCarbonFootprint`, `getDescription`).
- Polimorfismo: `ArrayList<CarbonFootprint>` contiene objetos de distintos tipos.
- Modularidad: cada clase se ubica en su archivo y paquete correspondiente.
- Reutilizacion: `CarbonFootprintFileManager` sirve para cualquier objeto que implemente la interfaz.
- Manejo de archivos: escritura de resultados en `data/carbon_footprint_results.txt` con `try-with-resources`.
- Pruebas unitarias: pruebas JUnit 5 por clase y para persistencia en archivo.
- SOLID:
  - SRP: cada clase con una responsabilidad unica.
  - OCP: se pueden agregar nuevas fuentes de huella sin romper la estructura central.
  - DIP: el flujo principal depende de la abstraccion `CarbonFootprint`.

## Estructura del proyecto

```text
carbon-footprint-java/
|- pom.xml
|- README.md
|- .gitignore
|- data/
|  |- carbon_footprint_results.txt
|- docs/
|  |- analisis_diseno.md
|  |- guia_video.md
|- src/
   |- main/java/edu/unisalle/carbon/
   |  |- CarbonFootprint.java
   |  |- Building.java
   |  |- Car.java
   |  |- Bicycle.java
   |  |- CarbonFootprintFileManager.java
   |  |- Main.java
   |- test/java/edu/unisalle/carbon/
      |- BuildingTest.java
      |- CarTest.java
      |- BicycleTest.java
      |- CarbonFootprintFileManagerTest.java
```

## Ejecucion

1. Compilar e instalar:
```bash
mvn clean install
```

2. Ejecutar pruebas:
```bash
mvn test
```

3. Ejecutar aplicacion:
```bash
mvn exec:java
```

## Estrategia de ramas Git

Ramas requeridas y flujo:
- `main`: rama principal del repositorio.
- `develop`: rama de integracion.
- `dev_ltuiran07`: rama final de trabajo y entrega de codigo.

Comandos de verificacion sugeridos:
- `git branch`
- `git branch -a`
- `git status`

## Evidencias

1. Estructura de carpetas del proyecto.
2. Ejecucion de `mvn test` con pruebas en verde.
3. Ejecucion de `mvn exec:java` mostrando resultados en consola.
4. Contenido de `data/carbon_footprint_results.txt`.
5. Salida de `git branch`, `git branch -a` y `git status` en `dev_ltuiran07`.
