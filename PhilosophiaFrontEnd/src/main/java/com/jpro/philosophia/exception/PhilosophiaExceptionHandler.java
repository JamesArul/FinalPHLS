package com.jpro.philosophia.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.validation.ConstraintViolationException;

import org.hibernate.exception.SQLGrammarException;
import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class PhilosophiaExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(PhilosophiaExceptionHandler.class);

	@ExceptionHandler(SQLException.class)
	public ModelAndView gotSqlException(Exception e)
	{
		log.debug("Start of method gotSqlException");
		ModelAndView mv=new ModelAndView("/Error");
		mv.addObject("error","SQLException");
		mv.addObject("errorMsg", e.getMessage());
		log.debug("End of method gotSqlException");
		return mv;
	}
	
	@ExceptionHandler(CannotCreateTransactionException.class)
	public ModelAndView gotdbServerNotStarted(Exception e)
	{
		log.debug("Start of method gotdbServerNotStarted");
		ModelAndView mv=new ModelAndView("/Error");
		mv.addObject("error","CannotCreateTransactionException");
		mv.addObject("errorMsg", e.getMessage());
		log.debug("End of method gotdbServerNotStarted");
		return mv;
	}

	@ExceptionHandler(QuerySyntaxException.class)
	public ModelAndView gotQuerySyntaxException(Exception e)
	{
		log.debug("Start of method gotQuerySyntaxException");
		ModelAndView mv=new ModelAndView("/Error");
		mv.addObject("error","QuerySyntaxException");
		mv.addObject("errorMsg", e.getMessage());
		log.debug("End of method gotQuerySyntaxException");
		return mv;
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView gotNoHandlerFoundException(Exception e)
	{
		log.debug("Start of method gotNoHandlerFoundException");
		ModelAndView mv=new ModelAndView("/Error");
		mv.addObject("error","NoHandlerFoundException");
		mv.addObject("errorMsg", e.getMessage());
		log.debug("End of method gotNoHandlerFoundException");
		return mv;
	}
	
	@ExceptionHandler(IOException.class)
	public ModelAndView gotIOException(Exception e)
	{
		log.debug("Start of method gotIOException");
		ModelAndView mv=new ModelAndView("/Error");
		mv.addObject("error","IOException");
		mv.addObject("errorMsg", e.getMessage());
		log.debug("End of method gotIOException");
		return mv;
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView gotConstraintException(Exception e)
	{
		log.debug("Start of method gotConstraintException");
		ModelAndView mv=new ModelAndView("/Error");
		mv.addObject("error","ConstraintViolationException");
		mv.addObject("errorMsg", e.getMessage());
		log.debug("End of method gotConstraintException");
		return mv;
	}
	
	@ExceptionHandler(SQLGrammarException.class)
	public ModelAndView gotSQLGrammarException(Exception e)
	{
		log.debug("Start of method gotSQLGrammarException");
		ModelAndView mv=new ModelAndView("/Error");
		mv.addObject("error","SQLGrammarException");
		mv.addObject("errorMsg", e.getMessage());
		log.debug("End of method gotSQLGrammarException");
		return mv;
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ModelAndView gotDataIntegrityViolationException(Exception e)
	{
		log.debug("Start of method gotDataIntegrityViolationException");
		ModelAndView mv=new ModelAndView("/Error");
		mv.addObject("error","DataIntegrityViolationException");
		mv.addObject("errorMsg", e.getMessage());
		log.debug("End of method gotDataIntegrityViolationException");
		return mv;
	}
	
	@ExceptionHandler(IllegalStateException.class)
	public ModelAndView gotIllegalStateException(Exception e)
	{
		log.debug("Start of method gotIllegalStateException");
		ModelAndView mv=new ModelAndView("/Error");
		mv.addObject("error","IllegalStateException");
		mv.addObject("errorMsg", e.getMessage());
		log.debug("End of method gotIllegalStateException");
		return mv;
	}
	
}