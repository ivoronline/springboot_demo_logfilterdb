package com.ivoronline.springboot_demo_logfilterdb.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ivoronline.springboot_demo_logfilterdb.entities.LogEntity;
import com.ivoronline.springboot_demo_logfilterdb.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class MyFilter extends OncePerRequestFilter {

  @Autowired LogRepository logRepository;

  @Override
  public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws IOException, ServletException {

    //DIVIDES HTTP REQUEST AND RESPONSE CODE
    chain.doFilter(request, response);

    //CREATE LOG
    LogEntity logEntity            = new LogEntity();
              logEntity.protocol   = request.getProtocol  ();
              logEntity.serverName = request.getServerName();
              logEntity.serverPort = request.getServerPort();
              logEntity.username   = request.getParameter ("username");
              logEntity.status     = response.getStatus();

    //STORE LOG
    logRepository.save(logEntity);

  }

}
