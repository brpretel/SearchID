# Search ID

Diseño y creación de una aplicación móvil para la búsqueda y reporte de documentos perdidos. 

<img src="https://github.com/brpretel/SearchID/blob/master/Images/logo.png" width="400" height="400">   

Figura 1. Logo\
Brian Samir Pretel Plata\
Ivan Santiago Galindo Orjuela\
Universidad EAN – Facultad de Ingeniería – Estructura De Datos\

### INTRODUCCIÓN
El presente proyecto tiene como principal objetivo la creación e implementación de una aplicación móvil que pretende solventar una problemática ocasional, la pérdida de los documentos en lugares públicos. Esta herramienta estará diseñada para tener la posibilidad de reportar documentos perdidos, y de la misma forma, facilitar su hallazgo por parte del propietario. 
El software hace uso de lenguajes de programación como Kotlin y Python, acompañado de una ardua implementación con FastAPI y MySQL, para la correcta creación y almacenamiento de datos. Así mismo, se realiza uso de la creación de las interfaces gráficas con la ayuda de Figma, para posteriormente ser finalizada en la interfaz UI de Android Studio.

### NECESIDAD / JUSTIFICACIÓN
En la actualidad, la perdida de documentos representa una gran preocupación para cualquier persona, pues es prácticamente imposible poder recuperar algo que no es rastreable. De esta forma, la intención principal es la de brindar una solución eficiente para cualquier persona que se encuentre en esta desesperada situación. Nuestro modelo de negocio se basa en conectar a personas que encontraron documentos perdidos con sus respectivos propietarios, sin ningún costo agregado, simplemente consumiendo en el proceso ads o avisos publicitarios que puedan respaldar el altruismo que representa la marca. 
Esta herramienta ha de ser tan abierta y accesible como sea posible, siempre haciendo correcto uso de los datos personales registrados y con una visión que propende por el bienestar y el altruismo en la sociedad. 

### REQUISITOS

| Número de requerimiento | RF001 |
| --- | --- |
| Nombre de requerimiento | Autenticación |
| Tipo | Requisito                                  |
| Fuente del requerimiento | Usuario |
| Proceso |La aplicación permite la comparación y validación de la información almacenada respecto a los usuarios para su posterior inicio de sesión en la plataforma |
| Prioridad del requerimiento | Esencial |

| Número de requerimiento | RF02 |
| --- | --- |
| Nombre de requerimiento | CRUD usuarios |
| Tipo | Requisito                                  |
| Fuente del requerimiento | Usuario |
| Proceso |El software permite y requiere la creación y modificación de los usuarios |
| Prioridad del requerimiento | Esencial |

| Número de requerimiento | RF03 |
| --- | --- |
| Nombre de requerimiento | Ingreso de documentos |
| Tipo | Requisito                                  |
| Fuente del requerimiento | Administrador |
| Proceso |La aplicación permite el registro de documentos perdidos (numero de documento, datos personales, ubicación e información de contacto) |
| Prioridad del requerimiento | Esencial |

| Número de requerimiento | RF04 |
| --- | --- |
| Nombre de requerimiento | Prohibición de usuarios duplicados |
| Tipo | Restricción                                  |
| Fuente del requerimiento | Administrador |
| Proceso |La aplicación restringe la creación de usuarios duplicados |
| Prioridad del requerimiento | Esencial |

| Número de requerimiento | RF05 |
| --- | --- |
| Nombre de requerimiento | Prohibición de datos duplicados |
| Tipo | Restricción                                  |
| Fuente del requerimiento | Administrador |
| Proceso |La aplicación impide el registro de documentos duplicados |
| Prioridad del requerimiento | Esencial |

| Número de requerimiento | RF06 |
| --- | --- |
| Nombre de requerimiento | Consulta de datos |
| Tipo | Requisito                                  |
| Fuente del requerimiento | Administrador |
| Proceso |La aplicación permite traer datos remotos guardados en una base de datos, para mostrarlos en la interfaz gráfica  |
| Prioridad del requerimiento | Esencial |

| Número de requerimiento | RF07 |
| --- | --- |
| Nombre de requerimiento | Encriptación de datos|
| Tipo | Requisito                                  |
| Fuente del requerimiento | Administrador |
| Proceso | La aplicación permite la encriptación de la información almacenada en las bases de datos |
| Prioridad del requerimiento | Esencial |

| Número de requerimiento | RF08 |
| --- | --- |
| Nombre de requerimiento | UI/UX |
| Tipo | Requisito                                  |
| Fuente del requerimiento | Administrador |
| Proceso | El programa cuenta con una interfaz gráfica fácil de usar y amena para el usuario, que permite evidenciar la información importante y secundaria |
| Prioridad del requerimiento | Esencial |

| Número de requerimiento | RF09 |
| --- | --- |
| Nombre de requerimiento | Almacenamiento |
| Tipo | Requisito                                  |
| Fuente del requerimiento | Administrador |
| Proceso | La aplicación permite el correcto almacenamiento de los datos en las bases de datos remota de una forma segura y confiable |
| Prioridad del requerimiento | Esencial |

## Herramientas utilizadas

# 1.	Kotlin
 
Figura 2. Logo Kotlin
Se refiere al lenguaje de programación principal para la realización de algoritmos enfocados en el sistema de operativo de Android, con una sintaxis basada en Java y que es flexible para ser usado en distintos dispositivos móviles.
Este lenguaje es compatible con los emuladores de Android Studio, y flexible con cualquier framework necesario para tareas avanzadas de lógica de software.

# 2.	Python

Figura 3. Logo Python
Se trata de uno de los lenguajes mas usados en la actualidad para la programación de algoritmos, desde los más básicos, hasta los más avanzados. En esta ocasión, su uso se enfoca en la implementación y alineamiento de la API para la autenticación y almacenamiento de datos remotamente. 


# 3.	FastAPI

Figura 4. Logo FastAPI
Uno de los frameworks más reconocidos actualmente por su facilidad para la construcción de APIs, basado en las anotaciones de tipo estándar de Python. Es preferida por su alto rendimiento y estabilidad, así mismo por la facilidad con la que se puede aprender y usar. Es rápido de programar y minimiza la longitud de código que podría evidenciarse con otras herramientas

# 4.	Android Studio
 
Figura 5. Logo Android Studio
Se trata del entorno de desarrollo integrado (IDE) mas usado para la creación y edición de código enfocado en el sistema operativo Android. Permite de la misma forma la implementación de interfaces virtuales con innumerables características, para hacer la experiencia de usuario la mejor posible. Incluye la implementación de emuladores con fines de testeo, bastante práctico para los cambios al código de manera inmediata. 

# 5.	Figma
 
Figura 6. Logo Figma
Es una aplicación web que permite el diseño de interfaces gráficas de manera sencilla para su posterior uso en Android Studio. Se hace uso de este software al brindar flexibilidad, estabilidad y confiabilidad para los diseños que se implementarán con el fin de mejorar la experiencia e interfaz de los usuarios.

# 6.	MySQL
 
Figura 7. LogoMySQL
Utilizado para el correcto almacenamiento de datos de forma segura y consistente. Se establece de forma remota con un servidor capaz de encriptar y desencriptar datos, los mismos que serán implementados en la aplicación móvil. Es fácil de usar y permite al administrador el simplificar el uso de las bases de datos. 

## ARQUITECTURA DE SOFTWARE
El proyecto está basado en el uso de "Modelo–vista–controlador" (MVC) ya que se encuentran seccionados y separados los datos de la interfaz y así mismo del algoritmo que usa la lógica. 
-	Modelos/Entidades: Es la representación de los datos guardados y requeridos desde el controlador, en este caso, el modelo o las entidades almacenan los datos enviados por el controlador, y garantizan la accesibilidad de la información, así mismo como su seguridad y consistencia.
-	Controladores: Hace referencia a las peticiones dadas para el modelo, en cuanto a la edición d ellos datos y de la misma forma la petición de los mismos, para posteriormente ser almacenados.
-	Vistas: Se trata de la interfaz de usuario, un espacio gráfico para que el usuario tenga una mejor guía en cuanto al uso del programa.

## UI
Una interfaz creada inicialmente en Figma para ser posteriormente adaptada a Android Studio, esta interfaz contiene los colores representativos de la marca y fue diseñada para hacer el uso del programa mas sencillo a los ojos del usuario.
 
Figura 8. Login de SearchID
 
Figura 9. Dashboard de SearchID
 
Figura 10. Pantalla de buscar Documentos

## RESULTADOS Y CONCLUSIONES
Es posible evidenciar el correcto funcionamiento de la aplicación, siendo esta capaz de almacenar los datos correctamente y así mismo mostrarlos sin mayor inconveniente. Los requisitos establecidos se cumplen a toda cabalidad y no existen dificultades que pongan en riesgo el correcto funcionamiento de los flujos de datos. 
La interfaz es totalmente funcional y el software trabaja sinérgicamente con todas las herramientas usadas. La seguridad de los datos tratados está garantizada ya que la encriptación de estos funciona sin ningún problema. La escalabilidad de las bases de datos usadas es amplia, y permite el crecimiento exponencial del numero de usuarios y por lo tanto de los documentos registrados.
Las herramientas utilizadas para la creación de esta aplicación abastecen de sobra las necesidades planteadas inicialmente y de la misma forma, cumplen con los objetivos de negocio propuestos. La conexión entre la interfaz de usuario, el controlador y los datos almacenados, son estables, permiten una accesibilidad total y aun mas importante, garantizan la seguridad al mantenerlos encriptados. 
