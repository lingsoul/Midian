/**
 * Copyright @ 2016jkzl. All rights reserved
 */
package com.midian.webtest.dataprovider;

/**
 * @author peter.Chen
 * @version 1.0
 *          <p>
 *          operation
 *          date                        operator         content
 *          2016/9/6 21:01             peter.Chen       new
 * @Description:
 * @date 2016/9/6 21:01
 */
public class UrlInfo {
    private String url;
    private String userName;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
