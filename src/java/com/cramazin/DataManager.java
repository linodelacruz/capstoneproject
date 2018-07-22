
package com.cramazin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class DataManager extends DBManager{
    
    private final List<User> users = new ArrayList<>();
    
    private final DataSource dataSource;   
    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    int profileimageid = 0;
    int postedimageid = 0;
    int coverimageid = 0;
    private User userFromResultSet(ResultSet resultSet) throws SQLException{
        return new User(resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("user_name"),
                        resultSet.getString("user_password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("profile_image_id")
        );
    }
    private UserProfile profileFromResultSet (ResultSet resultSet)throws SQLException {
         return new UserProfile(resultSet.getInt("id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("user_email"),
                        resultSet.getString("about_user"),
                        resultSet.getInt("zip_code"),
                        resultSet.getInt("profile_image_id"),
                        resultSet.getInt("cover_photo_id")
        );
    }
    private UserProfile globalProfileFromResultSet (ResultSet resultSet)throws SQLException {
         return new UserProfile(resultSet.getInt("id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("user_email"),
                        resultSet.getString("about_user"),
                        resultSet.getInt("zip_code"),
                        resultSet.getInt("profile_image_id"),
                        resultSet.getInt("cover_photo_id")
        );
    }
    
    
    private UserPost postFromResultSet (ResultSet resultSet)throws SQLException {
         return new UserPost(resultSet.getInt("id"),
                        resultSet.getString("user_name"),
                        resultSet.getInt("picture_post_id"),
                        resultSet.getString("text_post"),
                        resultSet.getDate("posted"),
                        resultSet.getInt("profile_image_id")
                        
        );
    }
    
    public ImageInfo profileImageInfoBy(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try{
            connection = dataSource.getConnection();
            statement =  connection.prepareStatement("select id, filename, content_type from profile_images where id = ?");   
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            
            if(resultSet.next()){
                return profileImageFromResultSet(resultSet);
            }  
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            close(resultSet);
            close(statement);
            close(connection);
        }
        return null;
    }
    public ImageInfo coverImageInfoBy(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try{
            connection = dataSource.getConnection();
            statement =  connection.prepareStatement("select id, filename, content_type from profile_images where id = ?");   
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            
            if(resultSet.next()){
                return coverImageFromResultSet(resultSet);
            }  
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            close(resultSet);
            close(statement);
            close(connection);
        }
        return null;
    }
    
    private ImageInfo postImageFromResultSet(ResultSet resultSet) throws SQLException {
        return new ImageInfo(resultSet.getInt("id"),
                resultSet.getString("filename"),
                resultSet.getString("content_type")
                
        );
    }
    private ImageInfo profileImageFromResultSet(ResultSet resultSet) throws SQLException {
        return new ImageInfo(resultSet.getInt("id"),
                resultSet.getString("filename"),
                resultSet.getString("content_type")
                
        );
    }
    private ImageInfo coverImageFromResultSet(ResultSet resultSet) throws SQLException {
        return new ImageInfo(resultSet.getInt("id"),
                resultSet.getString("filename"),
                resultSet.getString("content_type")
                
        );
    }
    
    public ImageInfo postImageInfoBy(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try{
            connection = dataSource.getConnection();
            statement =  connection.prepareStatement("select id, filename, content_type from picture_posts where id = ?");   
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            
            if(resultSet.next()){
                return postImageFromResultSet(resultSet);
            }  
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            close(resultSet);
            close(statement);
            close(connection);
        }
        return null;
    }
    
    private void copyIO(InputStream contentStream, OutputStream outputStream) throws IOException{
        try{
            byte[] buffer = new byte[32 * 1024];
            while(true){
                int numread = contentStream.read(buffer);
                if(numread < 1){
                    break;
                }
                outputStream.write(buffer, 0, numread);
            }
            
        }finally {
            contentStream.close();
        }
    }
    public boolean copyProfileImageContent(int id, OutputStream out){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT content FROM profile_images where id=?");
            statement.setInt(1, id);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                copyIO(resultSet.getBinaryStream("content"),out);
            }
        }catch (IOException | SQLException ex){
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return false;
    }
     public boolean copyCoverImageContent(int id, OutputStream out){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT content FROM profile_images where id=?");
            statement.setInt(1, id);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                copyIO(resultSet.getBinaryStream("content"),out);
            }
        }catch (IOException | SQLException ex){
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return false;
    }
    
    public boolean copyPostImageContent(int id, OutputStream out){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT content FROM picture_posts where id=?");
            statement.setInt(1, id);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                copyIO(resultSet.getBinaryStream("content"),out);
            }
        }catch (IOException | SQLException ex){
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return false;
    }
    public List<ImageInfo> allProfileImages() {

        List<ImageInfo> profileImages = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select id, filename, content_type from profile_images");
            while (resultSet.next()) {
                profileImages.add(profileImageFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return profileImages;
    }
    public List<ImageInfo> allImagePosts() {

        List<ImageInfo> postImages = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select id, filename, content_type from picture_posts");
            while (resultSet.next()) {
                postImages.add(postImageFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return postImages;
    }
    public UserProfile getGlobalUserProfile(String username){
        UserProfile globaluserprofile = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("select * from user_profile where user_name = ?");
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                globaluserprofile = globalProfileFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return globaluserprofile;
        
    }
    public UserProfile getUserProfile(String username){
        UserProfile userprofile = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("select * from user_profile where user_name = ?");
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userprofile = profileFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return userprofile;
        
    }
    
    public List<UserPost> getAllPosts(){
        List<UserPost> posts = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from user_post");
            while (resultSet.next()) {
                posts.add(postFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return posts;
        
    }
    public List<UserPost> getAllPostsFromUser(String username){
        List<UserPost> userPosts = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from user_post where user_name = ?");
            while (resultSet.next()) {
                userPosts.add(postFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return userPosts;
        
    }
    public List<ImageInfo> getProfileImage() {

        List<ImageInfo> images = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select id, filename, content_type from profile_images where id = ?");
            while (resultSet.next()) {
                images.add(profileImageFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return images;
    }
      public int saveProfileImage(String fileName, String contentType, InputStream inputStream) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet keySet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("INSERT INTO profile_images (filename, content_type, content) values (?, ?, ?)", new String[]{"id"});
            statement.setString(1, fileName);
            statement.setString(2, contentType);
            statement.setBinaryStream(3, inputStream);
            statement.execute();
            keySet = statement.getGeneratedKeys();
            keySet.next();
            profileimageid = keySet.getInt(1);//get image id from database
            return profileimageid;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(keySet);
            close(statement);
            close(connection);
        }
        return -1;
    } 
   public int updateProfileImage(String profileImageFileName, String profileImageContentType, InputStream inputStream) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet keySet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("INSERT INTO profile_images (filename, content_type, content) values (?, ?, ?)", new String[]{"id"});
            statement.setString(1, profileImageFileName);
            statement.setString(2, profileImageContentType);
            statement.setBinaryStream(3, inputStream);
            statement.execute();
            keySet = statement.getGeneratedKeys();
            keySet.next();
            profileimageid = keySet.getInt(1);//get image id from database
            return profileimageid;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(keySet);
            close(statement);
            close(connection);
        }
        return -1;
    }  
      public int updateCoverImage(String coverImageFileName, String coverImageContentType, InputStream inputStream) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet keySet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("INSERT INTO profile_images (filename, content_type, content) values (?, ?, ?)", new String[]{"id"});
            statement.setString(1, coverImageFileName);
            statement.setString(2, coverImageContentType);
            statement.setBinaryStream(3, inputStream);
            statement.execute();
            keySet = statement.getGeneratedKeys();
            keySet.next();
            coverimageid = keySet.getInt(1);//get image id from database
            return coverimageid;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(keySet);
            close(statement);
            close(connection);
        }
        return -1;
    }
        public int savePostedImage(String fileName, String contentType, InputStream inputStream) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet keySet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("INSERT INTO picture_posts (filename, content_type, content) values (?, ?, ?)", new String[]{"id"});
            statement.setString(1, fileName);
            statement.setString(2, contentType);
            statement.setBinaryStream(3, inputStream);
            statement.execute();
            keySet = statement.getGeneratedKeys();
            keySet.next();
            postedimageid = keySet.getInt(1);//get image id from database
            return postedimageid;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(keySet);
            close(statement);
            close(connection);
        }
        return -1;
    }   
    public User registerUser(String email, String username, String password, String password1, String firstname, String lastname, int profileimageid) {
        if (!password.equals(password1)) {
            return null;
        }
        if (!password.matches("^[^<>'\"` ]{8,20}")) {
            return null;
        } else {
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                connection = dataSource.getConnection();
                statement = connection.prepareStatement("SELECT email, user_name FROM users where email = ? or "
                        + "user_name = ?");
                statement.setString(1, email);
                statement.setString(2, username);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return null;
                } else {
                    
                    statement = connection.prepareStatement("INSERT INTO users (email,user_name, user_password,first_name, last_name, profile_image_id)"
                            + "values (?, ?, ?, ?, ?, ?)");
                    statement.setString(1, email);
                    statement.setString(2, username);
                    statement.setString(3, password);
                    statement.setString(4, firstname);
                    statement.setString(5, lastname);
                    statement.setInt(6, profileimageid);
                    statement.execute();
                    User newUser = new User(email, username, password, firstname, lastname, profileimageid);
                    users.add(newUser);
                    return newUser;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close(resultSet);
                close(statement);
                close(connection);
            }
            return null;

        }
    }
    public UserProfile updateUserProfile(String username,String firstname, String lastname, int zipcode, String aboutuser, int profileimageid, int coverimageid) {
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                connection = dataSource.getConnection();
                statement = connection.prepareStatement("UPDATE user_profile set (about_user, zip_code, profile_image_id, cover_photo_id, first_name, last_name) "
                        + "values (?, ?, ?, ?, ?, ?)where user_name = ?");
                statement.setString(1, aboutuser);
                statement.setInt(2, zipcode);
                statement.setInt(3, profileimageid);
                statement.setInt(4, coverimageid);
                statement.setString(5, firstname);
                statement.setString(6, lastname);
                statement.setString(7, username);
                
                statement.execute();
                
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close(resultSet);
                close(statement);
                close(connection);
            }
            return null;    
    }
    
    public User updateUser(String username, String firstname, String lastname, int profileimageid) {
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                connection = dataSource.getConnection();
                statement = connection.prepareStatement("UPDATE users set (first_name, last_name, profile_image_id) "
                        + "values (?, ?, ?)where user_name = ?");
                statement.setString(1, firstname);
                statement.setString(2, lastname);
                statement.setInt(3, profileimageid);
                                
                statement.execute();
                
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close(resultSet);
                close(statement);
                close(connection);
            }
            return null;    
    }
    
    
    public UserPost savePost(String username, int postedimageid, String postedtext) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("insert into user_post (user_name, picture_post_id, text_post) values (?,?,?)");
            statement.setString(1, username);
            statement.setInt(2, postedimageid);
            statement.setString(3, postedtext);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return null;
    }
    
    public User authenticate(String email, String password) {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
 
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM users where email = ? and "
                    + "user_password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            
            
            while (resultSet.next()){
                user = userFromResultSet(resultSet); 
                return user;
            }
        }catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close(resultSet);
                close(statement);
                close(connection);
            }
        return null;
    }
}

