package proyecto.utils;

import io.jsonwebtoken.*;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import proyecto.models.ClienteModel;

import javax.crypto.SecretKey;
import java.util.Date;

@Repository
public class JwtMiddlewareService{

    private final SecretKey secretKey;

    public JwtMiddlewareService(SecretKey secretKey){
        this.secretKey = secretKey;
    }

    public String generateToken(ClienteModel clienteModel){
        Date expiration_date = new Date(System.currentTimeMillis() + 86400000);
        return Jwts
                .builder()
                .claim("user_id", clienteModel.getId())
                .claim("name", clienteModel.getNombre())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expiration_date)
                .signWith(secretKey)
                .compact();
    }


    public Boolean validateToken(String token){
        try{
            Jws<Claims> jws = Jwts
                    .parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);
            return !jws.getPayload().getExpiration().before(new Date());
        }catch(ExpiredJwtException e){
            e.printStackTrace();
            return false;
        }catch(MalformedJwtException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ClienteModel decodeJWT(String token){
        Claims claims = Jwts
                .parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        ObjectId id = claims.get("user_id", ObjectId.class);
        String username = claims.get("name", String.class);

        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setId(id);
        clienteModel.setNombre(username);
        return clienteModel;
    }
}
