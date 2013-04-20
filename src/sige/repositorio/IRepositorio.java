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
	 *             lançado quando há problemas na conexão com o repositório
	 */
	void adicionarPessoa(Pessoa pessoa) throws RepositorioException;

	/**
	 * Remover Pessoa do repositorio
	 * 
	 * @param id
	 *            id da pessoa a ser removida
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	void removerPessoa(int id) throws RepositorioException;

	/**
	 * Atualizar as informações de uma pessoa no repositório
	 * 
	 * @param id
	 *            id da pessoa a ser alterada
	 * @param pessoa
	 *            novo objeto que representará a pessoa
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	void atualizarPessoa(int id, Pessoa pessoa) throws RepositorioException;

	/**
	 * Buscar todas as pessoas cadastradas no repositório
	 * 
	 * @return retorna uma arraylist com as pessoas cadastradas
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	ArrayList<Pessoa> recuperarPessoas() throws RepositorioException;

	/**
	 * Buscar Pessoa no repositorio a partir do id
	 * 
	 * @param id
	 *            id da pessoa
	 * @return retorna o resultado da busca pelo id em forma de ArrayList
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	ArrayList<Pessoa> buscarPessoaId(int id) throws RepositorioException;

	/**
	 * Buscar Pessoa no repositorio a partir do nome
	 * 
	 * @param nome
	 *            nome da pessoa
	 * @return retorna o resultado da busca pelo nome em forma de ArrayList
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	ArrayList<Pessoa> buscarPessoaNome(String nome) throws RepositorioException;

	/**
	 * Buscar Pessoa no repositorio a partir do cpf
	 * 
	 * @param cpf
	 *            cpf da pessoa
	 * @return retorna o resultado da busca pelo cpf em forma de ArrayList
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	ArrayList<Pessoa> buscarPessoaCpf(String cpf) throws RepositorioException;

	/**
	 * Adicionar matéria no repositorio
	 * 
	 * @param materia
	 *            objeto Materia a ser adicionado
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	void adicionarMateria(Materia materia) throws RepositorioException;

	/**
	 * Remover matéria do repositorio
	 * 
	 * @param id
	 *            id da materia a ser removida
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	void removerMateria(int id) throws RepositorioException;

	/**
	 * Atualizar informações de uma matéria no repositório
	 * 
	 * @param id
	 *            id da matéria para ser atualizada
	 * @param materia
	 *            novo objeto Matéria que substituirá o antigo
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	void atualizarMateria(int id, Materia materia) throws RepositorioException;

	/**
	 * Buscar todas as matérias registradas no repositório
	 * 
	 * @return retorna uma ArrayList com todas as matérias
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	ArrayList<Materia> recuperarMaterias() throws RepositorioException;

	/**
	 * Buscar matéria a partir do id
	 * 
	 * @param id
	 *            id da matéria a ser buscada
	 * @return retorna o resultado da busca em forma de ArrayList
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	ArrayList<Materia> buscarMateriaId(int id) throws RepositorioException;

	/**
	 * Buscar matéria a partir do nome
	 * 
	 * @param nome
	 *            nome da matéria a ser buscada
	 * @return retorna o resultado da busca nas matérias em forma de ArrayList
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	ArrayList<Materia> buscarMateriaNome(String nome)
			throws RepositorioException;

	/**
	 * Adicionar atividade/exercício no repositório
	 * 
	 * @param atividade
	 *            objeto Atividade a ser adicionado
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	void adicionarAtividade(Atividade atividade) throws RepositorioException;

	/**
	 * Remover atividade do repositório
	 * 
	 * @param id
	 *            id da atividade a ser removida
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	void removerAtividade(int id) throws RepositorioException;

	/**
	 * Atualizar atividade
	 * 
	 * @param id
	 *            id da atividade a ser atualizada
	 * @param atividade
	 *            objeto que substituirá o registro anterior no repositório
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	void atualizarAtividade(int id, Atividade atividade)
			throws RepositorioException;

	/**
	 * Recuperar as atividades registradas no repositório
	 * 
	 * @return retorna as atividades em um ArrayList
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	ArrayList<Atividade> recuperarAtividades() throws RepositorioException;

	/**
	 * Buscar atividade a partir o id
	 * 
	 * @param id
	 *            id da atividade a ser buscada
	 * @return retorna o resultado da busca pelo id em forma de ArrayList
	 * @throws RepositorioException
	 *             lançado quando há problemas na conexão com o repositório
	 */
	ArrayList<Atividade> buscarAtividadeId(int id) throws RepositorioException;
}
