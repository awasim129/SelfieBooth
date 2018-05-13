/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booth_ai;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
/**
 *
 * @author AWA
 */
public class CloudinaryAPI {
    
    public Cloudinary access = new Cloudinary(ObjectUtils.asMap("cloud_name", "selfiebooth","api_key", "416569729327625",
                                                                            "api_secret", "ovi36WylyxP8R_M88QGKFLJl3fM"));
    
    
} 
