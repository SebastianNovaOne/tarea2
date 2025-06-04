# tarea2
# Sebastian Nova Sanchez
# CAMBIOS AL UML DE REUNION:
#   Amplie el UML original para ser mejor usado en un sistema real.
#   Añadi los atributos organizador y tipo para identificar que usuario
#   convoca la reunion y por cual razon, esto sirve para informes.
#   Tambien, al ser la clase principal decidi añadir generarinforme()
#   y guardarInformeEnArchivo() (esto podria estar en un main)
# 
# CAMBIOS EN EL UML DE NOTA:
#   Añadi el metodo fechaCreacion para saber en que momento esta se hizo
# 
# CAMBIOS EN EL UML DE EMPLEADO:
#   Añadi el atributo Departamento para agregar el departamento al que pertenece
#   el empleado, tambien implemente el metodo invitar() de la interfaz Invitable
#   y ademas el metodo getNombreCompleto().
# CAMBIOS EN EL UML DE DEPARTAMENTO:
#   Añadi un atributo ArrayList que permite ver que empleados integran
#   al departamento, ademas añadi el metodo agregarEmpleados, pienso que
#   es una buena idea, le da flexibilidad.
# CAMBIOS EN EL UML DE INVITACION:
#   En invitacion ademas de la hora, añadi atributos y metodos que permiten
#   manejar si el invitado llega a la hora o con retraso o ausente
# NUEVA CLASE: INVITADOEXTERNO:
#   Esta clase la cree para poder manejar invitados que no pertenecen
#   al departamento, le puse de atributos NombreCompleto y correo, y tambien
#   añadi el metodo invitar().