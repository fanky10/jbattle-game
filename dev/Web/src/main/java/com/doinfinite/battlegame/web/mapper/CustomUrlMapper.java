package com.doinfinite.battlegame.web.mapper;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.module.sitemesh.Config;
import com.opensymphony.module.sitemesh.Decorator;
import com.opensymphony.module.sitemesh.DecoratorMapper;
import com.opensymphony.module.sitemesh.Page;
import com.opensymphony.module.sitemesh.mapper.AbstractDecoratorMapper;

public class CustomUrlMapper extends AbstractDecoratorMapper {
	public void init(Config config, Properties properties,
			DecoratorMapper parent) throws InstantiationException {
		super.init(config, properties, parent);
	}

	public Decorator getDecorator(HttpServletRequest request, Page page) {
		if (getServerAndPort(request).contains("m.")) {
			return getNamedDecorator(request, "MOBILE");
		}
		return getNamedDecorator(request, "WEB");
	}

	// TODO: encapsulate into helper if needed
	private String getServerAndPort(HttpServletRequest request) {
		String port = "";
		if (request.getServerPort() != 80) {
			port = ":" + request.getServerPort();
		}
		String urlAddress = request.getScheme() + "://"
				+ request.getServerName() + port + request.getContextPath()
				+ "/";

		return urlAddress;
	}
}