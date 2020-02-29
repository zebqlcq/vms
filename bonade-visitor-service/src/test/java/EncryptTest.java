import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;
import org.spin.core.util.DateUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * TITLE
 * <p>DESCRIPTION</p>
 * <p>Created by xuweinan on 2019/9/19</p>
 *
 * @author xuweinan
 * @version 1.0
 */
public class EncryptTest {

    @Test
    void testEncrypt() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("atrOP2s8bfLGkUG5");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.salt.NoOpIVGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        String decrypt = encryptor.decrypt("UtMcMdASQ6Ng3QQuk4aReA==");
        System.out.println(decrypt);
        System.out.println(encryptor.encrypt("admin"));
    }

    @Test
    void tt(){
       System.out.println(DateUtils.formatDateForSecond(LocalDateTime.now()));
    }
}
