const tabelaAcao = {
    "Corumbá": 'ir para miranda',
    'Miranda': 'ir para anastacio',
    'Anastácio': 'ir para Campo Grande',
    'Campo Grande' : 'curtir o passeio',
}

const percepcao = ['Corumbá', 'Miranda', 'Anastácio', 'Campo Grande']

function exibirAcao(tabela, percepcao){
    console.log(tabela[percepcao])
}

exibirAcao(tabelaAcao, percepcao[0])
exibirAcao(tabelaAcao, percepcao[1])
exibirAcao(tabelaAcao, percepcao[2])
exibirAcao(tabelaAcao, percepcao[3])