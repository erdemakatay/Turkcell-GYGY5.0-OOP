open class Bildirim {
    open fun bildirimGonder(mesaj: String) {
        println("Bildirim gonderiliyor: $mesaj")
    }
}

class EmailBildirim : Bildirim() {
    override fun bildirimGonder(mesaj: String) {
        println(" EMAIL: $mesaj")
    }
}

class SmsBildirim : Bildirim() {
    override fun bildirimGonder(mesaj: String) {
        println(" SMS: $mesaj")
    }
}

class PushBildirim : Bildirim() {
    override fun bildirimGonder(mesaj: String) {
        println(" PUSH: $mesaj")
    }
}

fun main() {
    val bildirimler: List<Bildirim> = listOf(
        EmailBildirim(),
        SmsBildirim(),
        PushBildirim()
    )

    val mesaj = "Sistem bakimi tamamlandi, uygulamamizi kullanabilirsiniz!"

   
    if (mesaj.isEmpty()) {
        println("Hata: Gonderilecek bir mesaj bulunamadi!")
    } else {
        
        println("Sistem kontrol edildi: Mesaj gonderime hazir.\n")
        
        for (bildirim in bildirimler) {
            bildirim.bildirimGonder(mesaj)
        }
        
        println("\nTum bildirimler basariyla gonderildi.")
    }
} 

