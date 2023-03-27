package Models.Entidades

class VersoesDosComponentesPadraoTiss {

    String competencia
    String publicacao
    String inicioVirgencia

    VersoesDosComponentesPadraoTiss(String competencia, String publicacao, String inicioVirgencia) {
        this.competencia = competencia
        this.publicacao = publicacao
        this.inicioVirgencia = inicioVirgencia
    }

    @Override
    String toString() {
        return "Competencia: " + competencia + " - " +
                "Publicacao: " + publicacao + " - " +
                "Inicio de Virgencia: " + inicioVirgencia
    }
}
