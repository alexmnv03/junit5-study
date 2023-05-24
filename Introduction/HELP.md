# 03 - созадем первые тесты

# 04 Рассмотрим жизненный цикл тестов

![life_cicle.png](src/main/resources/life_cicle.png)

@BeforeEach - код выполняемый перед каждым тестом
@AfterEach - код выполняемый после каждого теста
@BeforeAll - код выполняемый перед всеми тестатми, один раз
@AfterAll - код выполняемый после всех тестов, один раз

Добавим их в наш код
BeforeAll и AfterAll это статические методы, для начала нам андо определить тип эизненгго цикла
```aidl
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
```
Но если мы зададим настройки
```aidl
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
```
Что означает, что объект будет создан в единственном экземпляре, то нам не нужно обявлять эти 
методы как статические, т.к. они так будут созданы в единственном экземпляре

Разберемся как мы можем запускать тесты

Рассмотирм как устроена схема

![shema](src/main/resources/shema.png)
На схеме мы видим, что IDEA (Maven) используют junit-platform-launcher
Подключим эту зависимость в проекте
Создадим класс TestLauncher
Запустим метод main нашего класса на выполнение и увидим отчет по нашим тестам

Вот таким образом можно запустаить тесты самостоятельно. Именно так их и запускает наша IDE.


# Сторонние библиотеки

Есть более удобные билиотеке для assert
## asserj - вроде как самая удобная
подключим ее

## hamcrest
подключим ее

# Исключения
Проверим, что метод пробрасывает исключение
Создадим метод trowExeptionIfUsernameOrPasswordIsNull в котором проверим, что наш метод 
пробрасывает исключения в случае пердачи нулевых значений
Но если мы хотим проверить еще и password , то нам придется написат ьеще один тест или блок, 
поэтому мы будем использоваоть другой подход используюя спец assert см метод trowsExeptionIfUsernameOrPasswordIsNull

Допустим нам необходимо проверить, что выпало именно наше исключение см. метод 