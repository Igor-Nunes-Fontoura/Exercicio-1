/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    public Connection conn;
    public String sql;
    public PreparedStatement prep;
    public ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        conn = new conectaDAO().connectDB();
        
        try {
            sql = "insert into produtos(nome, valor, status) values (?, ?, ?)";
            prep = conn.prepareStatement(sql);
            
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            
            prep.execute();
            prep.close();
            
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ops! Houve um problema ao cadastrar o produto.");
            
        }
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos() {
        conn = new conectaDAO().connectDB();
    
        try {
            sql = "SELECT * FROM produtos";
            prep = conn.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int valor = rs.getInt("valor");
                String status = rs.getString("status");

                produto.setId(id);
                produto.setNome(nome);
                produto.setValor(valor);
                produto.setStatus(status);

                listagem.add(produto);
            }
            
            prep.close();
            conn.close();
            
        } catch (SQLException ex) {
            System.out.println("Erro!");
            
        }

        return listagem;
    }
    
}
