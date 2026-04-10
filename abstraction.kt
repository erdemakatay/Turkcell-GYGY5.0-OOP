// Soyut sýnýfýmýzý oluþturuyoruz.

abstract class Kargo(
    val kargoNo: Int,
    val musteriAdi: String?
) {
    abstract fun ucretHesapla(): Double

    fun musteriBilgisiYazdir() {
        if (musteriAdi != null) {
            println("Musteri: $musteriAdi")
        } else {
            println("Musteri bilgisi yok")
        }
    }
}


// Standart kargo adýnda bir class tanýmlýyoruz ve kargo sýnýfýndan kalýtým alýyoruz.

class StandartKargo(
    kargoNo: Int,
    musteriAdi: String?,
    private val urunler: List<String>,
    private val fiyatlar: Array<Double>
) : Kargo(kargoNo, musteriAdi) {

    private val secilenUrunler = mutableListOf<Int>()

    fun urunSec(index: Int) {
        if (index in urunler.indices) {
            secilenUrunler.add(index)
        }
    }

    override fun ucretHesapla(): Double {
        var toplam = 0.0
        for (i in secilenUrunler) {
            toplam += fiyatlar[i]
        }
        return toplam
    }

    fun urunleriYazdir() {
        println("Urunler:")
        for (i in urunler.indices) {
            println("${i + 1} - ${urunler[i]} : ${fiyatlar[i]} TL")
        }
    }
}

// Hýzlý kargo adýnda bir  sýnýf  tanýmlýyoruz ve kargo sýnýfýndan kalýtým alýyoruz


class HizliKargo(
    kargoNo: Int,
    musteriAdi: String?,
    private val paketler: MutableList<String>
) : Kargo(kargoNo, musteriAdi) {

    override fun ucretHesapla(): Double {
        var toplam = 0.0
        for (paket in paketler) {
            toplam += 50.0 // Her paket için 50 TL
        }
        return toplam
    }

    fun paketEkle(paket: String) {
        paketler.add(paket)
    }
}

fun kargoOzetiYazdir(
    kargo: Kargo,
    mesajGoster: Boolean = true
) {
    println("=== Kargo Ozeti ===")
    kargo.musteriBilgisiYazdir()

    val ucret = kargo.ucretHesapla()
    println("Toplam Ucret: $ucret TL")

    if (mesajGoster) {
        // Ýstediðin o özel teþekkür mesajý burada:
        println("Firmamizi tercih ettiginiz icin tesekkür ederiz, Guzel gunlerde kullaniniz...")
    }
}

fun main() {
    val fiyatlar = arrayOf(100.0, 200.0, 300.0)
    val urunler = listOf("Telefon", "Laptop", "Tablet")

    val kargo1 = StandartKargo(
        kargoNo = 1,
        musteriAdi = "Erdem",
        urunler = urunler,
        fiyatlar = fiyatlar
    )

    kargo1.urunleriYazdir()

    print("Kac urun sececeksiniz? ")
    val input = readLine()
    val adet = input?.toIntOrNull() ?: 0

    for (i in 1..adet) {
        print("$i. urunun numarasini girin: ")
        val secim = readLine()?.toIntOrNull() ?: 0
        kargo1.urunSec(secim - 1)
    }

    kargoOzetiYazdir(
        kargo = kargo1,
        mesajGoster = true
    )
}


