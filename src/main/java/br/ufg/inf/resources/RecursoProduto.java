/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.resources;

import br.ufg.inf.dto.Produto;
import com.google.gson.Gson;
import br.ufg.inf.dao.ProdutoDAO;

import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;


@Path("produtos")
public class RecursoProduto {

    private final ProdutoDAO produtoDao = new ProdutoDAO();

    @GET
    @Produces("application/json; charset=utf-8")
    public String getProdutos() {
        //Usamos a biblioteca Gson (da Google) para facilitar converter objeto
        //em Json e vice-versa
        // Acessa todos produtos por http://localhost:8080/FBE_Aula4/resources/
        String produtos = null;
        List<Produto> prodLista = produtoDao.getProdutos();
        try {
            Gson gson = new Gson();
            produtos = gson.toJson(prodLista);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtos;
    }

    @Path("{codigo}")
    @GET
    @Produces("application/json; charset=utf-8")
    public String getProduto(@PathParam("codigo") String codigo) {
        // Acessa o produtos por http://localhost:8080/FBE_Aula4/resources/produtos/0001, 002, ... 
        String prod = null;
        Produto produto = produtoDao.getProduto(codigo);
        try {
            Gson gson = new Gson();
            prod = gson.toJson(produto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prod;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json; charset=utf-8")
    public String addProduto(String prod) {
        try {
            Gson gson = new Gson();

            Produto produto = gson.fromJson(prod, Produto.class);
            produtoDao.addProduto(produto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json; charset=utf-8")
    public String setProduto(String prod) {
        try {
            Gson gson = new Gson();

            Produto produto = gson.fromJson(prod, Produto.class);
            produtoDao.updateProduto(produto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @DELETE
    @Path("del/{codigo}")
    //@Produces("application/json" + ";charset=utf-8")
    public String delProduto(@PathParam("codigo") String codigo) {
        try{
            produtoDao.delProduto(Integer.parseInt(codigo));

        } catch (Exception e){
            e.printStackTrace();
        }

        return "";
    }

}
