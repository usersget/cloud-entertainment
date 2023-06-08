package org.cyt.common;


/**
 * @ClassName CreateGwt
 * @Description 生成TOKEN
 * @Author CYT
 * @LastChangeDate 2022/11/24 13:04
 * @Version v2.0.1
 */
public class CreateGwt {
//    public static String gotoken(User user){
//        JwtBuilder builder = Jwts.builder().setId(user.getId()+"")
//                .setSubject(user.getUsername())
//                .setIssuedAt(new Date())//登陆时间
//                .signWith(SignatureAlgorithm.HS256,"my-123")
//                .setExpiration(new Date(
//                        new Date().getTime()+86400000
//                ));//设置过86400000
//        //System.out.println(builder.compact());
//        return builder.compact();
//    }
//
//    /**
//     * 验证token
//     * @return  token正确返回对象，token不正确返回null
//     */
//    public static Claims getClaimByToken(User user,String token){
//        Claims jwt;
//        try {
//         jwt  =  Jwts.parser()
//                    .setSigningKey("my-123")  //获取秘钥
//                    .parseClaimsJws(token)    //解析验证token
//                    .getBody();
//        }catch (Exception e){
//            //System.out.println("验证失败");
//            return  null;
//        }
//        return jwt;
//    }
}
