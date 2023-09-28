const tabelaAcao = {
    A: {value: 'CHAO_SUJO', acao: "Limpar"},
    B: {value: 'CHAO_LIMPO', acao: 'Virar à direita'},
}

const percepcao = ['CHAO_SUJO', 'CHAO_LIMPO']

function exibirAcao(tabela, percepcao){
    Object.values(tabela).map((posicao) => {
        if(posicao.value === percepcao){
            console.log(posicao.acao)
        }
    })
}

exibirAcao(tabelaAcao, percepcao[0])
exibirAcao(tabelaAcao, percepcao[1])