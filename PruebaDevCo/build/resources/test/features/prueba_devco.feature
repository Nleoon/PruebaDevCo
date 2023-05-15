Feature: Prueba DevCo

  @NotaNegritaScenario1
  Scenario Outline: Crear una nota de texto enriquecido con letra en negrita
    Given el usuario ingresa en bloc de notas online
    When  ingresa en el apartado 'Nota de texto enriquecido' donde crea su nota <nota_usuario> en negrita
    Then la nota se ha creado con exito

    Examples:
    |nota_usuario|
    |Buen día, presento la prueba tecnica devCo by: NicolasBolivarLeon|
