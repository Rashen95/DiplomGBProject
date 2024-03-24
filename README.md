### EndPoints:

Все EndPoints доступны по адресу localhost:8080

#### For ALL:

Данные Endpoints используются для регистрации, логирования через frontend (при вводе адреса localhost:8080
вы будете автоматически переведены на страничку логина).
По итогу логирования вы будете перенаправлены на страничку получения токена, который
в дальнейшем используется в Postman для обращения к другим Endpoints)

1. @GetMapping("/login") - получение странички для логирования
2. @PostMapping("/login/log") - передача данных логина серверу.
3. @GetMapping("/registration") - получение странички для регистрации
4. @PostMapping("/registration/reg") - передача данных регистрации серверу.

#### For ADMIN:

1. @GetMapping("/admin/list") - получение списка всех заявок
2. @GetMapping("/admin/list_by_status") - получение списка всех заявок по статусу. Принимает параметром *status (
   not_started; in_progress; complete)*.
3. @PutMapping("/admin/{id}") - изменение статуса заявки по *id*. Принимает параметром новый *status (not_started;
   in_progress; complete)*, *id* берется из пути.
4. @DeleteMapping("/admin/{id}") - удаление заявки по *id*. *id* берется из пути.
5. @DeleteMapping("/users/{id}") - удаление пользователя по *id*. *id* берется из пути.

#### For USER:

1. @PostMapping("/applications/create") - создание заявки. Принимает параметрами *name* и *description*.
2. @GetMapping("/user/list") - получение списка всех заявок данного пользователя.
3. @GetMapping("/user/list_by_status") - получение списка всех заявок по статусу данного пользователя. Принимает
   параметром *status (not_started; in_progress; complete)*.

### DB:

Для создания БД необходимо:

1. Наличие установленного docker, docker-compose
2. В папке проекта применить команду docker-compose up. База данных автоматически создастся с необходимыми сущностями.
   для подключения использовать:
    - Адрес: jdbc:postgresql://localhost:5432/rashen-db
    - user: root
    - password: root.
