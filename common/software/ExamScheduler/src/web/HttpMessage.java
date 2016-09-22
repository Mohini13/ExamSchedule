/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.HashMap;

/**
 *
 * @author Suhn
 */
public class HttpMessage {
    HashMap<String, String> headers = new HashMap();
    HashMap<String, String> parameters = new HashMap();
        
    String version = null;
    String body = null;
}
