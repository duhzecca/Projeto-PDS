/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import auxiliar.BDConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DataDao {
	private Connection connection;

	public DataDao() throws Exception {
		connection = BDConnection.getConnection(true);
	}

	public ArrayList<String> getFrameWork(String frameWork) {
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement ps = null;
		String data;
		try {
			ps = connection
					.prepareStatement("SELECT * FROM remedio  WHERE nome  LIKE ?");
			ps.setString(1, frameWork + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getString("nome");
				list.add(data);
			}
                        System.out.println(ps.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
