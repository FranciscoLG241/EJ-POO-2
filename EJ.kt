

import kotlin.math.pow

class persona(val peso: Double, var altura: Double){

    var nombre: String = ""
        set(value){
            require(value.isNotBlank()){"El nombre no debe estar vacío ni ser nulo"}
            field = value
        }


    val imc: Double
        get() = obtenerImc()


    constructor(nombre: String, peso: Double, altura: Double): this(peso, altura){
        this.nombre = nombre
    }


    private fun obtenerImc(): Double{
        return peso / altura.pow(2)
    }


    override fun toString(): String {
        return "nombre: ${nombre}, peso: ${peso}, altura: ${altura}, imc: ${imc}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is persona) return false

        return peso == other.peso && altura == other.altura && nombre == other.nombre
    }

    override fun hashCode(): Int {
        var result = peso.hashCode()
        result = 31 * result + altura.hashCode()
        result = 31 * result + nombre.hashCode()
        return result
    }


}



fun main(){

    val persona1 = persona(70.0, 1.75)
    val persona2 = persona("Juan", 80.0, 1.80)
    val persona3 = persona("Maria", 65.0, 1.65)



    println("Persona 1: $persona1")
    println("Persona 2: $persona2")
    println("Persona 3: $persona3")

    print("Introduce un nombre para persona1")
    persona1.nombre = readLine()?:""
    println("Nombre de Persona 1: ${persona1.nombre}, Peso: ${persona1.peso}, Altura: ${persona1.altura}")

    println("Persona 3 -> Peso: ${persona3.peso}, Altura: ${persona3.altura}, IMC: ${"%.2f".format(persona3.imc)}")

    persona3.altura = 1.80
    println("Persona 3 (actualizado) -> Peso: ${persona3.peso}, Altura: ${persona3.altura}, IMC: ${"%.2f".format(persona3.imc)}")

    persona2.altura = persona3.altura

    println("Persona 2: $persona2")
    println("Persona 3: $persona3")

    val sonIguales = persona2 == persona3
    println("¿Persona 2 y Persona 3 son iguales? $sonIguales")


}