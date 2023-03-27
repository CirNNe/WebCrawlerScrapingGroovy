package Models.DAO

import Models.Entidades.VersoesDosComponentesPadraoTiss

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class VersoesComponentesDAO extends GenericDAO<VersoesDosComponentesPadraoTiss> {

    boolean inserirDadosNaTabelaVersoesComponentes(VersoesDosComponentesPadraoTiss versoesDosComponentesPadraoTiss) {

        String sql = "INSERT INTO versoes_componentes(competencia, publicacao, inicio_virgencia) VALUES(?, ?, ?)"

        try {
            Connection conexao = super.conectar()
            PreparedStatement inserirVersoesComponentes = conexao.prepareStatement(sql)

            inserirVersoesComponentes.setString(1, versoesDosComponentesPadraoTiss.competencia)
            inserirVersoesComponentes.setString(2, versoesDosComponentesPadraoTiss.publicacao)
            inserirVersoesComponentes.setString(3, versoesDosComponentesPadraoTiss.inicioVirgencia)

            inserirVersoesComponentes.execute()
            conexao.close()
            return true

        } catch (Exception e) {
            e.printStackTrace()
            return false
        }
    }

    boolean confereDadosDaTabelaVersoesComponentes(VersoesDosComponentesPadraoTiss versoesDosComponentesPadraoTiss) {

        String sql = "SELECT competencia, publicacao, inicio_virgencia FROM versoes_componentes"

        try {
            Connection conexao = conectar()
            PreparedStatement buscarDadosVersoesComponentes = conexao.prepareStatement(sql)
            ResultSet resultSet = buscarDadosVersoesComponentes.executeQuery()

            List competencias = new ArrayList()

            while (resultSet.next()) {
                String competencia = resultSet.getString("competencia")
                competencias.add(competencia)
            }

            buscarDadosVersoesComponentes.close()
            resultSet.close()
            conexao.close()

            return !competencias.contains(versoesDosComponentesPadraoTiss.competencia)

        } catch (Exception e) {
            e.printStackTrace()
            return false
        }
    }

    boolean leDadosTabelaVersoesComponentes() {

        String sql = "SELECT competencia, publicacao, inicio_virgencia FROM versoes_componentes ORDER BY TO_DATE(publicacao, 'DD/MM/YYYY') DESC"

        try {


            Connection conexao = conectar()
            PreparedStatement buscarDadosVersoesComponentes = conexao.prepareStatement(sql)
            ResultSet resultSet = buscarDadosVersoesComponentes.executeQuery()

            List<VersoesDosComponentesPadraoTiss> versoesComponentes = new ArrayList()

            while (resultSet.next()) {
                String competencia = resultSet.getString("competencia")
                String publicacao = resultSet.getString("publicacao")
                String inicio_virgencia = resultSet.getString("inicio_virgencia")
                VersoesDosComponentesPadraoTiss versoesDosComponentesPadraoTiss = new VersoesDosComponentesPadraoTiss(competencia, publicacao, inicio_virgencia)
                versoesComponentes.add(versoesDosComponentesPadraoTiss)
            }

            for(int posicao = 0; posicao < versoesComponentes.size(); posicao++) {
                println(versoesComponentes[posicao])
            }

        } catch (Exception e) {
            e.printStackTrace()
            return false
        }
    }
}
