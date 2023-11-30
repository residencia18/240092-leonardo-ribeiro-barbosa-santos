class Pessoa {

    public string nome {get;set;}
    public datetime dataDeNascismento {get;set;}
    public int cpf {get;set;}

class Advogado:Pessoa {
    private int cna{get;set:}

}


Cliente : Pessoa {
    private string estadoCivil{get;set;}
}


Escritorio {
    List<Advogado> advogados = new List<Advogado>();
    List<Cliente> clientes= new List<Cliente>();
}




}


static void main {





}