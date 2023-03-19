fun main(args: Array<String>) {
    val phoneNumber = "+38(099)519-54-70"

    /**Вивести в консоль номер без коду країни(у такому форматі: (ххх)ххх-хх-хх**/
    println("Номер без коду країни: ${phoneNumber.removePrefix("+38")}")

    /**Вивести в консоль код оператора (099) без дужок**/
    println("Код оператора: ${phoneNumber.substringAfter('(').substringBefore(')')}")

    /**Порахувати кількість цифр у номері(попередньо) видаливши усі зайві символи зі строки,
     * а саме: "+", "(", ")", "-". Результат вивести в консоль**/
    val numSeparators = "+()-" //це у нас константне значення, оскільки у задачі було вказано, що треба видалити конкретні символи
    var TotalAmtOfNums: Int = 0
    var stringWithoutSeparators = phoneNumber
    //видаляємо непотрібні знаки
    numSeparators.forEach { e ->
        stringWithoutSeparators = stringWithoutSeparators.filterNot { it == e}
    }
    //рахуємо кількість цифр
    stringWithoutSeparators.forEach { e -> TotalAmtOfNums++}
    println("Кількість цифр у номері:$TotalAmtOfNums")

    /**Вивести в консоль номер без коду країни та оператора(у такому форматі: ххххххх - без розділових дефісів)**/
    println("Номер без коду країни та оператора: ${phoneNumber.substringAfter(')').filterNot { it == '-' }}")

    /**Порівняти першу та передостанню цифру номера телефону, результат вивести у консоль**/
    var firstNum = stringWithoutSeparators.first()
    var penultNum = stringWithoutSeparators[stringWithoutSeparators.length - 2]
    //варіант порівняння 1: просто виводимо результат як є: 1, 0 або -1
    println("Результат порівняння першого та передостаннього числа: ${firstNum.compareTo(penultNum)}")

    //варіант порівняння 2: із використанням if...else
    if (firstNum > penultNum){
        println("Перша цифра більша ніж передостання")
    }else if (firstNum < penultNum){
        println("Перша цифра менша ніж передостання")
    }else{
        println("Перша цифра рівна передостанній")
    }

    /**Знайти середнє арифметичне усіх чисел номера та піднести отримане число до степеня "2/3". Отриманий результат вивести у консоль**/
    //знаходимо суму всіх чисел
    var sumOfNums = 0
    stringWithoutSeparators.forEach { e -> sumOfNums+=e.digitToInt()}
    //знаходимо середнє арифметичне
    var average = (sumOfNums/TotalAmtOfNums).toDouble()
    //підносимо до степеня
    var exponent = 2.0/3.0
    var result = Math.pow(average, exponent)
    println(String.format("Середнє арифметичне усіх чисел номера, піднесене до степеня (2/3): %.3f", result))
}