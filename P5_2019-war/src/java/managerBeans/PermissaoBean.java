/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.Constantes;
import util.GeradorCodigo;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class PermissaoBean 
{
    private static Map< String, String> mapa = new HashMap< String, String>();

    public PermissaoBean()
    {
    }

    public boolean validar(String funcionalidade)
    {
         ContaBean contaBean = (ContaBean) GeradorCodigo.getInstanciaBean("contaBean");
         String tipo_perfil = contaBean.findTipoPerfilByNomeUsuario().trim();
        return verificarFuncionalidadePorTipoPerfil(tipo_perfil, funcionalidade);
    }

    static
    {

        PermissaoBean.mapa.put("cliente",
               Constantes.FUNCIONALIDADE_CLIENTE_MENU + "-"
                + Constantes.FUNCIONALIDADE_CLIENTE_ADD +"-"
                + Constantes.FUNCIONALIDADE_MONTRA_VISUALIZA_PRODUTOS + "-"
                + Constantes.FUNCIONALIDADE_MONTRA_MENU
        );

        PermissaoBean.mapa.put("cliente cadastrado",
                Constantes.FUNCIONALIDADE_MONTRA_MENU + "-"
                + Constantes.FUNCIONALIDADE_MONTRA_VISUALIZA_PRODUTOS + "-"
                + Constantes.FUNCIONALIDADE_CARRINHO + "-"
                + Constantes.FUNCIONALIDADE_COMPRAR_PRODUTO
        );

        PermissaoBean.mapa.put("funcionario",
                Constantes.FUNCIONALIDADE_ARMAZEM_MENU + "-"
                + Constantes.FUNCIONALIDADE_ARMAZEM_ADD_PRODUTO + "-"
                + Constantes.FUNCIONALIDADE_ARMAZEM_ENTRADA_PRODUTO + "-"
                + Constantes.FUNCIONALIDADE_ARMAZEM_LISTAR_PRODUTO + "-"
                        
                + Constantes.FUNCIONALIDADE_MONTRA_MENU + "-"
                + Constantes.FUNCIONALIDADE_MONTRA_ADD_PRODUTO + "-"
                + Constantes.FUNCIONALIDADE_MONTRA_REMOVE_PRODUTO + "-"
                + Constantes.FUNCIONALIDADE_MONTRA_VISUALIZA_PRODUTOS
        );

        PermissaoBean.mapa.put("admin",
                
                Constantes.FUNCIONALIDADE_ARMAZEM_MENU + "-"
                + Constantes.FUNCIONALIDADE_ARMAZEM_ADD_PRODUTO + "-"
                + Constantes.FUNCIONALIDADE_ARMAZEM_PRECO_PRODUTO + "-"
                + Constantes.FUNCIONALIDADE_ARMAZEM_LISTAR_PRODUTO + "-"
                + Constantes.FUNCIONALIDADE_ARMAZEM_DEFINIR_QUANTIDADE_MAXIMA + "-"
                + Constantes.FUNCIONALIDADE_ARMAZEM_ENTRADA_PRODUTO + "-" 
                        
                + Constantes.FUNCIONALIDADE_MONTRA_MENU + "-"
                + Constantes.FUNCIONALIDADE_MONTRA_ADD_PRODUTO + "-"
                + Constantes.FUNCIONALIDADE_MONTRA_REMOVE_PRODUTO + "-"
                + Constantes.FUNCIONALIDADE_MONTRA_VISUALIZA_PRODUTOS + "-"
                
                + Constantes.FUNCIONALIDADE_FUNCIONARIO_MENU + "-"
                + Constantes.FUNCIONALIDADE_FUNCIONARIO_ADD + "-"
                + Constantes.FUNCIONALIDADE_FUNCIONARIO_LISTAR + "-"
                        
                + Constantes.FUNCIONALIDADE_BALANCETES_MENU + "-"
                + Constantes.FUNCIONALIDADE_BALANCETES_DIARIOS + "-"
                + Constantes.FUNCIONALIDADE_BALANCETES_MENSAIS + "-"
                + Constantes.FUNCIONALIDADE_BALANCETES_INTERVALO_TEMPO + "-"
                + Constantes.FUNCIONALIDADE_BALANCETES_TIPO_PRODUTO + "-"
                + Constantes.FUNCIONALIDADE_LISTAGEM_EM_RUPTURA + "-"
                + Constantes.FUNCIONALIDADE_LISTAGEM_QUASE_RUPTURA + "-"
                + Constantes.FUNCIONALIDADE_LISTAGEM_PRE_RUPTURA + "-"
                + Constantes.FUNCIONALIDADE_TABELA_MENU + "-"
        );
    }

    private boolean verificarFuncionalidadePorTipoPerfil(String tipoPerfil, String funcionalidade)
    {
        if (tipoPerfil.equals(Constantes.PERFIL_ROOT))return true;

        for (int i = 0; i < mapa.size(); i++)
        {
            if (PermissaoBean.mapa.containsKey(tipoPerfil))
            {
                String vectFuncinalidadesPermitidas[] = PermissaoBean.mapa.get(tipoPerfil).split("-");
                for (String vectFuncinalidadesPermitida : vectFuncinalidadesPermitidas)
                {
                    if (vectFuncinalidadesPermitida.equals(funcionalidade))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
}