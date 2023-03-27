package Models.DAO

import java.sql.Connection
import java.sql.DriverManager

class GenericDAO<T> {

    Connection conectar() {
        Properties propriedades = new Properties()
        propriedades.setProperty("user", "higor") as Connection
        propriedades.setProperty("password", "4deNovembro") as Connection
        propriedades.setProperty("ssl", "false") as Connection
        String ULR_SERVIDOR = "jdbc:postgresql://localhost:5432/cursoWebCrawler"

        try {
            return DriverManager.getConnection(ULR_SERVIDOR, propriedades)
        } catch (Exception e) {
            e.printStackTrace()
            if(e instanceof ClassNotFoundException) {
                println("Verifique o drive de conexão.")
            } else {
                println("Verifique se o servidor está ativo.")
            }
            System.exit(-42)
            return null
        }
    }

}
