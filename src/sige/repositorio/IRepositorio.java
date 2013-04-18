package sige.repositorio;

import java.util.ArrayList;

import sige.sistema.*;

/**
 * 
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 */
public interface IRepositorio {
	/**
	 * Adicionar Pessoa no repositorio
	 * 
	 * @param pessoa
	 *            objeto a ser adicionado
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	void adicionarPessoa(Pessoa pessoa) throws RepositorioException;

	/**
	 * Remover Pessoa do repositorio
	 * 
	 * @param id
	 *            id da pessoa a ser removida
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	void removerPessoa(int id) throws RepositorioException;

	/**
	 * Atualizar as informa��es de uma pessoa no reposit�rio
	 * 
	 * @param id
	 *            id da pessoa a ser alterada
	 * @param pessoa
	 *            novo objeto que representar� a pessoa
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	void atualizarPessoa(int id, Pessoa pessoa) throws RepositorioException;

	/**
	 * Buscar todas as pessoas cadastradas no reposit�rio
	 * 
	 * @return retorna uma arraylist com as pessoas cadastradas
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	ArrayList<Pessoa> recuperarPessoas() throws RepositorioException;

	/**
	 * Buscar Pessoa no repositorio a partir do id
	 * 
	 * @param id
	 *            id da pessoa
	 * @return retorna o resultado da busca pelo id em forma de ArrayList
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	ArrayList<Pessoa> buscarPessoaId(int id) throws RepositorioException;

	/**
	 * Buscar Pessoa no repositorio a partir do nome
	 * 
	 * @param nome
	 *            nome da pessoa
	 * @return retorna o resultado da busca pelo nome em forma de ArrayList
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	ArrayList<Pessoa> buscarPessoaNome(String nome) throws RepositorioException;

	/**
	 * Buscar Pessoa no repositorio a partir do cpf
	 * 
	 * @param cpf
	 *            cpf da pessoa
	 * @return retorna o resultado da busca pelo cpf em forma de ArrayList
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	ArrayList<Pessoa> buscarPessoaCpf(String cpf) throws RepositorioException;

	/**
	 * Adicionar mat�ria no repositorio
	 * 
	 * @param materia
	 *            objeto Materia a ser adicionado
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	void adicionarMateria(Materia materia) throws RepositorioException;

	/**
	 * Remover mat�ria do repositorio
	 * 
	 * @param id
	 *            id da materia a ser removida
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	void removerMateria(int id) throws RepositorioException;

	/**
	 * Atualizar informa��es de uma mat�ria no reposit�rio
	 * 
	 * @param id
	 *            id da mat�ria para ser atualizada
	 * @param materia
	 *            novo objeto Mat�ria que substituir� o antigo
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	void atualizarMateria(int id, Materia materia) throws RepositorioException;

	/**
	 * Buscar todas as mat�rias registradas no reposit�rio
	 * 
	 * @return retorna uma ArrayList com todas as mat�rias
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	ArrayList<Materia> recuperarMaterias() throws RepositorioException;

	/**
	 * Buscar mat�ria a partir do id
	 * 
	 * @param id
	 *            id da mat�ria a ser buscada
	 * @return retorna o resultado da busca em forma de ArrayList
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	ArrayList<Materia> buscarMateriaId(int id) throws RepositorioException;

	/**
	 * Buscar mat�ria a partir do nome
	 * 
	 * @param nome
	 *            nome da mat�ria a ser buscada
	 * @return retorna o resultado da busca nas mat�rias em forma de ArrayList
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	ArrayList<Materia> buscarMateriaNome(String nome)
			throws RepositorioException;

	/**
	 * Adicionar atividade/exerc�cio no reposit�rio
	 * 
	 * @param atividade
	 *            objeto Atividade a ser adicionado
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	void adicionarAtividade(Atividade atividade) throws RepositorioException;

	/**
	 * Remover atividade do reposit�rio
	 * 
	 * @param id
	 *            id da atividade a ser removida
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	void removerAtividade(int id) throws RepositorioException;

	/**
	 * Atualizar atividade
	 * 
	 * @param id
	 *            id da atividade a ser atualizada
	 * @param atividade
	 *            objeto que substituir� o registro anterior no reposit�rio
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	void atualizarAtividade(int id, Atividade atividade)
			throws RepositorioException;

	/**
	 * Recuperar as atividades registradas no reposit�rio
	 * 
	 * @return retorna as atividades em um ArrayList
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	ArrayList<Atividade> recuperarAtividades() throws RepositorioException;

	/**
	 * Buscar atividade a partir o id
	 * 
	 * @param id
	 *            id da atividade a ser buscada
	 * @return retorna o resultado da busca pelo id em forma de ArrayList
	 * @throws RepositorioException
	 *             lan�ado quando h� problemas na conex�o com o reposit�rio
	 */
	ArrayList<Atividade> buscarAtividadeId(int id) throws RepositorioException;
}
