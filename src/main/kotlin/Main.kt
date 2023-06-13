import kotlin.system.measureNanoTime
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

fun complexCalc() {
    val list = generateSequence(0) { it + 1 }.take(1_000_000).toList()
    println(list.average())
}
@OptIn(ExperimentalTime::class)
fun main() {
    println("Hello World!")
    val p = System.currentTimeMillis()
    while (true) {
       // println(measureNanoTime {
        println(measureTimedValue {
            complexCalc()
        })
        Thread.sleep(1000)
    }
    println(System.currentTimeMillis() - p)
// время выполнения будет гулять
// системное время иногда корректируется назад
// чуть лучше measureNanoTime или measureTimedValue

}
// другой подход - снимать слепки через JVM
// нужно Java Mission Control (Oracle)
// ставим запускаем JDK Mission Control 8.3.1+b05
// смотрим процессы JVM
// записываем сколько-то времени
// анализируем что  чем занято и как
// выясняем и вешаем на это тест

// другоие инструменты
// YourKit JDK Java Profiler - платный 14 дней через почту
// тоже самое но удобнее и точнее и шире
// + сборная интегрированная панель
// отслеживается работа с БД
// разного уровня семплирование: синхронное асинхронное низкоуровневое и самое простое - только вызовы

// Visual VM 2.1.6 - свободный - вижу плагин для Идея и AS
// возможности похожи на  YourKit JDK Java Profiler
// у него есть классная коллекция плагинов внутри него

// Альтернативные сэмплеры (Не Джава)
// в IntellJ Ultimate есть прямо профилер моды
// async-profiler - open source https://github.com/async-profiler/async-profiler.git
// в Ultimate плагин уже включен
// можно тестировать только отдельный метод
// умеет делать отчет с передачей в др отчетные системы
// в мас у него работает как системная утилита

// в Ultimate можно запустить приложение с профайлером или плагинами-профайлерами
// можно выставить в настройках
// по этому выясняем проблемные модули и на них Assertion

// DataDog Java Profiler - интегрируется с JVM и используется для онлине наблюдения за приложением

// BENCHMARK
// jhm https://github.com/openjdk/jmh.git - есть плагин
// Java Microbenchmark - встраивается и расставляем маячки
// В чистом виде не испоользуют (больно) лучше
// https://github.com/Kotlin/kotlinx-benchmark.git
// jоснована на jmh полноценный Gradle plugin
// открыл стандартный пример kotlinx-benchmark
// в гредле подключения и настройки: configurations и targets
// в самом тесте куча аннотаций по типу Junit, но @Benchmark
// запуск теста и измерение его (среднего) времени итд
// это чистое время выполнения уонкретной функции
// делаем свои конфигурации и можно smoke тесты
// после него без автомата парсить Json результатов

// Android Profiler
// прямо из AS запускаем профилирование на эмулятор

// Java штука прохо прогнозируемая - куча фоновых процессов
