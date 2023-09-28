const posicoes = {
    'P1': 'A',
    'P2': 'B',
    'P3': 'C'
}

const estados = { 
    'E1': 'Sujo nível 1', 
    'E2': 'Sujo nível 2', 
    'E3': 'Limpo nível 1', 
    'E4': 'Limpo nível 2' 
}

function definirAcao(posicao, estado) {
    if (posicoes['P1'] === posicao) {
        if (estados[estado] === estados['E1']) {
            console.log('Limpar com detergente')
        }

        if (estados[estado] === estados['E2']) {
            console.log('Limpar com água sanitaria')
        }

        if (estados[estado] === estados['E3']) {
            console.log('passar pano úmido')
        }

        if (estados[estado] === estados['E4']) {
            console.log('ignorar')
        }
    }

    if (posicoes['P2'] === posicao) {
        if (estados[estado] === estados['E1']) {
            console.log('Limpar com detergente')
        }

        if (estados[estado] === estados['E2']) {
            console.log('Desifetar')
        }

        if (estados[estado] === estados['E3']) {
            console.log('ignorar')
        }

        if (estados[estado] === estados['E4']) {
            console.log('ignorar')
        }
    }

    if (posicoes['P3'] === posicao) {
        if (estados[estado] === estados['E1']) {
            console.log('Limpar com sabão em barra')
        }

        if (estados[estado] === estados['E2']) {
            console.log('Limpar com água sanitaria')
        }

        if (estados[estado] === estados['E3']) {
            console.log('passar pano úmido')
        }

        if (estados[estado] === estados['E4']) {
            console.log('ignorar')
        }
    }
}

definirAcao('A', 'E1')
definirAcao('A', 'E2')
definirAcao('A', 'E3')
definirAcao('B', 'E2')
definirAcao('C', 'E3')