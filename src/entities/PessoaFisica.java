package entities;

public class PessoaFisica extends Pessoa {
    private double gastoSaude;

    public PessoaFisica(){
    }

    public PessoaFisica(String nome, double rendaAnual, double gastoSaude) {
        super(nome, rendaAnual);
        this.gastoSaude = gastoSaude;
    }

    public double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }

    @Override
    public double PagarImposto() {
        if(getRendaAnual() <20000){
            return getRendaAnual() * 0.15 - getGastoSaude() * 0.50;
        }else{
            return getRendaAnual() * 0.25 - getGastoSaude() * 0.50;
        }
    }
}
