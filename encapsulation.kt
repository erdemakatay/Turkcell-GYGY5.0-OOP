class BankaHesabi {

    // Bakiye değişkeni, doğrudan erişime kapatıldı ve sadece sınıf içinden erişilebilir hale getirildi.
    var bakiye: Int = 1250
        private set   // Veriye doğrudan erişim gizlendi.

    fun paraYatir(miktar: Int) {
        if (miktar > 0) {
            bakiye += miktar
            println("$miktar TL yatirildi. Guncel bakiye: $bakiye TL")
        } else {
            println("Hata: Negatif miktar yatirilamaz!")
        }
    }

    fun paraCek(miktar: Int) {
        if (miktar > 0 && miktar <= bakiye) {
            bakiye -= miktar
            println("$miktar TL cekildi. Kalan bakiye: $bakiye TL")
        } else {
            println("Hata: Yetersiz bakiye veya gecersiz miktar!")
        }
    }
}

fun main() {
    val hesabim = BankaHesabi()
    
    hesabim.paraYatir(500) 
    hesabim.paraCek(200)   
}


