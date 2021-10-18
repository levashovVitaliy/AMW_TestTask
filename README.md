Тесты запускать из класса "TestRunner" который расположен в "src/test/java/TestRunner.java" или xml файл "smoke-all" который расположен в "src/test/java/suites/smoke-all.xml"

В процессе выполнения задания сделал следующие шаги-проверки:
условно разделил страницу на секции: 
    - "Header" section
          - проверил текст в Title
          - проверил основной текст секции
          - проверил ScreenResizer
               - сделал ожидание начальной анимации ScreenResizer
               - проверил работу ScreenResizer
               - проверил появление текстового блока при установки ScreenResizer в правой части страницы
               - проверил появление текстового блока при установки ScreenResizer в левой части страницы
              
    - "WTF?" section
         - проверил основной текст секции
         - проверил присутствие в секции блока с видео
         - проверил название проигрываемого ресурса(видео) - "Nebula_DAO_electron.mp4"
         
    - "Progress" section
         - проверил присутствие всех текстовых блоков секции
         - проверил анимацию движения иконки(со стрелкой) после hover-a по ссылке "LEARN MORE ABOUT US"
                - проверил (наличие соответственного ccs класса в атрибуте тэга отвечающего за инимацию)
                - проверил движение иконки(со стрелкой) после hover по иконке(со стрелкой)
         - проверил url страницы после нажатия на ссылку "LEARN MORE ABOUT US"
    
    - "Evolution" section
         - проверил присутствие всех текстовых блоков секции
         - проверил, что картинка в секции видна пользователю
        
    - "Nebula" section
         - проверил присутствие всех текстовых блоков секции
         - проверил анимацию движения бэкграунд картинки секции после hover-a по кнопке "ENTER THE NEBULA" (наличие css классва в атрибуте тэга отвечающего за анимацию)
         - проверил url страницы после нажатия на кнопку "ENTER THE NEBULA"        
        
    - "FAQ" section
         - проверил основной текст секции
         - проверил корректность работы ссылок которые содержаться в дропдаун меню
                - проверил url после перехода по ссылкам
         - проверил количество и названия дропдаун меню в секции
         - проверил открытие всех дропдаун меню
         - проверил изменение положения "стрелки" после нажатия на неё(во время открытия дропдаун меню)
         - проверил количество текстовых блоков в каждом дропдаун меню
         
    - "Footer" section
         - проверил корректность работы ссылок которые содержаться в секции
                - проверил url страницы после перехода по ссылкам