package top.ourck.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import top.ourck.beans.Category;
import top.ourck.utils.JDBCconnectionFactory;

public class CategoryDao implements SimpleDao<Category> {

	// Category table has only 2 columns: (id, name).
	
	@Override
	public void add(Category obj) {
		String sql = "INSERT INTO category values(null, ?)"; 
		try {
			PreparedStatement stmt = JDBCconnectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, obj.getName());
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys(); // Fill in the empty id field back of bean.
			if(rs.next()) {
				int id = rs.getInt(1);
				obj.setId(id);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			Statement stmt = JDBCconnectionFactory.getConnection().createStatement();
			String sql = "DELETE FROM category WHERE id = " + id;
			stmt.execute(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Category obj) {
		String sql = "UPDATE category set name = ? WHERE id = ?";
		try {
			PreparedStatement stmt = JDBCconnectionFactory.getConnection().prepareStatement(sql);
			
			stmt.setString(1, obj.getName());
			stmt.setInt(2, obj.getId());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Category query(int id) {
		Category c = null;
		try {
			String sql = "SELECT * FROM category WHERE id = ?";
			PreparedStatement stmt = JDBCconnectionFactory.getConnection().prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) { // Only 1 item.
				c = new Category();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public List<Category> list(int start, int count) {
		List<Category> list = new LinkedList<>();
		try {
			String sql = "SELECT * FROM category ORDER BY id DESC LIMIT ?, ?";
			PreparedStatement s = JDBCconnectionFactory.getConnection().prepareStatement(sql);
			s.setInt(1, start);
			s.setInt(2, count);
			ResultSet rs = s.executeQuery();
			
			while(rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Category> list() {
		return list(0, Short.MAX_VALUE);
	}

	@Override
	public int getTotal() {
		int n = 0;
		try {
			Statement stmt = JDBCconnectionFactory.getConnection().createStatement();
			String sql = "SELECT COUNT(*) FROM category";
			ResultSet rs = stmt.executeQuery(sql);
			//n = rs.getFetchSize();
			while(rs.next()) {
				n = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	public static void main(String[] args) {
		Category c = new Category("ZZZZZZzZZZ");
		CategoryDao cd = new CategoryDao();
		
		cd.add(c);
		cd.delete(c.getId());
		c.setName("ASDFGHJKL");
		cd.update(c);
		System.out.println(cd.query(c.getId()));
		
		System.out.println(cd.getTotal() + " " + cd.list());
	}
}
