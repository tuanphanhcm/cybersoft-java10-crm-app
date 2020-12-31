package com.cyberlogitec.filter;

import javax.servlet.annotation.WebFilter;

import com.cyberlogitec.util.Path;
import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@WebFilter(filterName = "sitemesh", urlPatterns = Path.ROOT)
public class Sitemesh extends SiteMeshFilter {

}
