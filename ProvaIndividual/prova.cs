class Pessoa {

    public string nome {get;set;}
    public datetime dataDeNascismento {get;set;}
    public int cpf {get;set;}

class Advogado:Pessoa {
    public int cna{get;set:}

}


Cliente : Pessoa {
    public string estadoCivil{get;set;}
}


Escritorio {
    List<Advogado> advogados = new List<Advogado>();
    List<Cliente> clientes= new List<Cliente>();

    public bool adicionarAdvogado(Advogado advogado)
{
    if (!advogados.Exists(a => a.CPF == advogado.CPF) && !advogados.Exists(a => a.CNA == advogado.CNA))
    {
        advogados.Add(advogado);
        return true;
    }
    return false;
}



}




}


static void main {

Escritorio escritorio = new Escritorio();
escritorio.adicionarAdvogado();



}