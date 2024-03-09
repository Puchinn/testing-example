### Unit & Integration Tets: Examples & Tasks

- Agregar un nuevo test unitario en `PaymentServiceTest`, que sea parametrizado, recibiendo dos valores de tipo Integer distintos, uno mayor, y otro menor que el monto limite definido en `PaymentService`. El objetivo es que dicho test, pueda controlar tanto el caso success, como el caso que lanza la excepcion de forma parametrizada y centralizada.

- Agregar un nuevo metodo a `PaymentService`, que reciba como parametro dos booleanos, y un string << lo que deseen realizar en dicho metodo es a criterio libre >>. Una vez definido este metodo, realizar un test unitario que cumpla con 100% coverage para el mismo. Recordar que por cada bifuracion o similar, tendremos una nueva arista de posibiliades donde debemos testear. 

- Asociado al item anterior, crear un nuevo metodo para `PaymentController`, que utilice el metodo recien creado en `PaymentService` y en caso de recibir un String en null, retornar. Sino, continuar hacia el uso del servicio. Crear test de integracion para el mismo, y la excepcion que se considere necesaria, tambien, con 100% coverage.