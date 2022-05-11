import RPi.GPIO as GPIO
from time import sleep

GPIO.setmode(GPIO.BCM)

sleepTime = .1

lightPin = 18
buttonPin1 = 17
buttonPin2 = 22
buttonPin3 = 23
buttonPin4 = 25
'''geeft aan welke knop op welke pin zit'''

GPIO.setup(13,GPIO.OUT)
servo1 = GPIO.PWM(13,50)
numbers = [0,2,3,0]
spelen = True
'''numbers is de reeks van getallen die geraden moet worden spelen word gebruikt om de loop te blijven doen'''
gedrukte_knop = 0
i = 0
juisten = 0
fouten = 0
'''Tellers voor het bijhouden van gegevens'''


def letter_g():
    GPIO.setup(lightPin, GPIO.OUT)
    sleep(3)
    GPIO.setup(lightPin, GPIO.OUT)
    sleep(3)
    GPIO.setup(lightPin, GPIO.OUT)
    sleep(1)


def letter_delay():
    GPIO.setup(lightPin, GPIO.OUT)
    sleep(3)


while spelen:
    servo1.start(0)
    print("ik wacht even")
    sleep(1)
    '''hierboven zet de code de motor recht naar boven. dat is dus de startpositie.
    hij gebruikt hier geen 2 omdat die hieronder pas wordt gedeclareerd.'''
    duty = 2
    while duty <= 4:
        servo1.ChangeDutyCycle(duty)
        sleep(1)
        duty = duty + 1
    '''hier zegt hij dus dat als hij lager is dan 4 hij nog één tik verder moet. Als hij die
        4 heeft gehaald stopt hij'''

    print("klik knop")
    GPIO.setup(buttonPin1, GPIO.IN, pull_up_down=GPIO.PUD_UP)
    GPIO.setup(buttonPin2, GPIO.IN, pull_up_down=GPIO.PUD_UP)
    GPIO.setup(buttonPin3, GPIO.IN, pull_up_down=GPIO.PUD_UP)
    GPIO.setup(buttonPin4, GPIO.IN, pull_up_down=GPIO.PUD_UP)
    # def button_callback(channel):
    #     print("knop1")
    # GPIO.add_event_detect(10,GPIO.RISING,callback=button_callback)


    def button1(channel):
        print("Button1 was pushed!")


    GPIO.add_event_detect(buttonPin1, GPIO.RISING, callback=button1)
    # GPIO.add_event_detect(buttonPin2, GPIO.RISING, callback=button_callback)
    # GPIO.add_event_detect(buttonPin3, GPIO.RISING, callback=button_callback)
    # GPIO.add_event_detect(buttonPin4, GPIO.RISING, callback=button_callback)

    # if not GPIO.input(buttonPin1) == GPIO.HIGH:
    #     gedrukte_knop = 0
    #     GPIO.setup(lightPin, GPIO.HIGH)
    #     print("Button1 was pushed!")
    # if not GPIO.input(buttonPin2) == GPIO.HIGH:
    #     gedrukte_knop = 1
    #     GPIO.setup(lightPin, GPIO.HIGH)
    #     print("Button2 was pushed!")
    # if not GPIO.input(buttonPin3) == GPIO.HIGH:
    #     gedrukte_knop = 2
    #     GPIO.setup(lightPin, GPIO.HIGH)
    #     print("Button3 was pushed!")
    # if not GPIO.input(buttonPin4) == GPIO.HIGH:
    #     gedrukte_knop = 3
    #     GPIO.setup(lightPin, GPIO.HIGH)
    #     print("Button4 was pushed!")
    '''Als knop1 word ingedrukt zet gedrukte knop naar x, zet het licht aan en print buttonx was pushed'''
    sleep(0.1)
    if gedrukte_knop == 0 or gedrukte_knop == 1 or gedrukte_knop == 2 or gedrukte_knop == 3:
        if gedrukte_knop == numbers[i]:
            juisten += 1
            i += 1
            print(str(juisten)+ " juist")
        elif gedrukte_knop != numbers[i]:
            fouten += 1
            print("aantal fouten: "+ str(fouten))
    '''als de gedrukte knop de juiste in de array is tel 1 op bij i en juisten
       en als de gedrukte knop fout is tel 1 op bij fout'''
    sleep(0.1)
    if fouten == 3:
        print("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEH")
        juisten = 0
        fouten = 0
        i = 0
    '''als er drie fouten gemaakt zijn print eeee en reset de tellers'''
    if i == len(numbers):
        letter_g()
        letter_delay()
        letter_g()
        servo1.ChangeDutyCycle()(0)
        sleep(2)
        servo1.stop
        GPIO.cleanup()
        print("WOOOOH YEAH BABY!!!")
        juisten = 0
        fouten = 0
        i = 0
    '''als de array voltooid is print WOOOOH YEAH BABY!!! en reset de tellers laat lampje branden met morse code'''
