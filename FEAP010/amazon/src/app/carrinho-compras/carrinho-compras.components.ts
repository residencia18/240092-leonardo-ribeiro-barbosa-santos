import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

// Interface para os itens do carrinho
export interface Item {
  Id: number;
  Name: string;
  Price: number;
  Quantity: number;
  imgURL: string;
}

@Component({
  selector: 'app-carrinho-compras',
  templateUrl: './carrinho-compras.components.html',
  styleUrls: ['./carrinho-compras.components.css']
})
export class CarrinhoComprasComponent implements OnInit {
  // Lista de itens no carrinho, usando BehaviorSubject para facilitar reatividade
  listaDeItens: BehaviorSubject<Item[]> = new BehaviorSubject<Item[]>([]);

  // Dados do novo produto para ser adicionado ao carrinho
  novoProduto: Item = {
    Id: 0,
    Name: '',
    Price: 0,
    Quantity: 1,
    imgURL: '',
  };

  // Subtotal do carrinho
  subtotal: { total: string; quantidade: number } = { total: 'R$ 0,00', quantidade: 0 };
  salvosParaDepois: any;

  constructor() {}

  ngOnInit(): void {
    // Produtos iniciais para exemplo
    const produtos: Item[] = [
      { Id: 1, Name: 'Smartphone', Price: 1500, Quantity: 1, imgURL: 'https://imgs.casasbahia.com.br/55058035/1g.jpg' },
      { Id: 2, Name: 'Notebook', Price: 2500, Quantity: 1, imgURL: 'https://www.havan.com.br/media/catalog/product/cache/73a52df140c4d19dbec2b6c485ea6a50/n/o/notebook-samsung-intel-celeron-4gb-ram-256gb-tela-de-15-6-w11-home_808259.jpg' },
      { Id: 3, Name: 'Fone de Ouvido', Price: 100, Quantity: 1, imgURL: 'https://m.media-amazon.com/images/I/51h6Ac2ILJL._AC_UF1000,1000_QL80_.jpg' },
    ];

    // Inicia a lista de itens
    this.listaDeItens.next(produtos);

    // Atualiza o subtotal com base nos itens iniciais
    this.subtotal = this.calcularSubtotal(produtos);
  }

  // Função para adicionar um item ao carrinho
  adicionarAoCarrinho() {
    const itensAtuais = this.listaDeItens.getValue();

    // Cria um novo item com ID único baseado no número de itens atuais
    const novoItem: Item = {
      Id: itensAtuais.length + 1,
      Name: this.novoProduto.Name,
      Price: this.novoProduto.Price,
      Quantity: this.novoProduto.Quantity,
      imgURL: this.novoProduto.imgURL,
    };

    // Adiciona o novo item ao carrinho
    this.listaDeItens.next([...itensAtuais, novoItem]);

    // Recalcula o subtotal
    this.subtotal = this.calcularSubtotal([...itensAtuais, novoItem]);
  }

  // Função para remover um item do carrinho
  removerItemDoCarrinho(index: number) {
    const itensAtuais = this.listaDeItens.getValue();
    itensAtuais.splice(index, 1);
    this.listaDeItens.next(itensAtuais);
    this.subtotal = this.calcularSubtotal(itensAtuais);
  }

  // Função para aumentar a quantidade de um item no carrinho
  aumentarQuantidade(index: number) {
    const itensAtuais = this.listaDeItens.getValue();
    itensAtuais[index].Quantity++;
    this.listaDeItens.next(itensAtuais);
    this.subtotal = this.calcularSubtotal(itensAtuais);
  }

  // Função para diminuir a quantidade de um item no carrinho
  diminuirQuantidade(index: number) {
    const itensAtuais = this.listaDeItens.getValue();
    if (itensAtuais[index].Quantity > 0) {
      itensAtuais[index].Quantity--;
    }
    this.listaDeItens.next(itensAtuais);
    this.subtotal = this.calcularSubtotal(itensAtuais);
  }
  

  // Função para calcular o subtotal do carrinho
  calcularSubtotal(itens: Item[]): { total: string, quantidade: number } {
    let total = 0;
    let quantidade = 0;

    itens.forEach(item => {
      total += item.Price * item.Quantity;
      quantidade += item.Quantity;
    });

    return { total: this.formatarMoeda(total), quantidade };
  }

  // Função para formatar valores como moeda (R$)
  formatarMoeda(valor: number): string {
    return valor.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
  }

  salvarParaDepois(index: number) {
    const itensAtuais = this.listaDeItens.getValue();
    const itemSalvo = itensAtuais.splice(index, 1)[0]; // remove do carrinho e adiciona à lista de salvos para depois
    this.salvosParaDepois.push(itemSalvo);
    this.listaDeItens.next(itensAtuais); // atualiza a lista
  }

  compartilharItem(item: Item) {
    console.log('Compartilhar Item chamado:', item); // Verifica se a função foi chamada
  
    const textoParaCopiar = `Confira este produto: ${item.Name} - Preço: R$ ${item.Price}. Veja a imagem: ${item.imgURL}`;
    
    navigator.clipboard.writeText(textoParaCopiar)
      .then(() => {
        console.log('Texto copiado para a área de transferência'); // Deveria aparecer no console
        alert('Texto copiado para a área de transferência!'); // Alerta para visualização
      })
      .catch((err) => {
        console.error('Erro ao copiar para a área de transferência:', err); // Se houver erro, exibirá no console
      });
  
}
}
