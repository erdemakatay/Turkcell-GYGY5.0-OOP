// Üst sýnýfýmýz

open class BilgiSistemi(
    var isim: String,
    var yas: Int,
    var adres: String,
    var hobiler: Array<String>
) {

    open fun goster() {
        println("--- Temel Bilgiler ---")
        println("Adi: $isim")
        println("Yasi: $yas")
        println("Adres: $adres")
        println("Hobiler: ${hobiler.joinToString(", ")}")
    }
}

// Alt sýnýfýmýz 

class YazilimciBilgisi(
    isim: String,
    yas: Int,
    adres: String,
    hobiler: Array<String>,
    var uzmanlikAlani: String,
    var kullandigiDiller: List<String>,
) : BilgiSistemi(isim, yas, adres, hobiler) {

    private val projeler = mutableListOf<String>()

    fun projeEkle(proje: String) {
        projeler.add(proje)
    }

    fun seviyeBelirle() {
        if (yas >= 25) {
            println("Seviye: Senior")
        } else {
            println("Seviye: Junior")
        }
    }

    override fun goster() {
        super.goster()

        println("--- Mesleki Bilgiler ---")
        println("Uzmanlik: $uzmanlikAlani")
        println("Diller: ${kullandigiDiller.joinToString(", ")}")

        println("Projeler: ${projeler.joinToString(", ")}")
    }
}

fun main() {

    val erdem = YazilimciBilgisi(
        isim = "Erdem",
        yas = 23,
        adres = "Adana",
        hobiler = arrayOf("Fitness", "Yazilim", "Seyahat etmek"),
        uzmanlikAlani = "Android Gelistirici",
        kullandigiDiller = listOf("Kotlin", "Java", "SQL")
    )

    erdem.projeEkle("Mobil Banka Uygulamasi")
    erdem.projeEkle("E-ticaret Uygulamasi")

    erdem.goster()
    erdem.seviyeBelirle()
}


