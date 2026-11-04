package com.technova.helpdesk.domain;
/*
 * O QUE É UM ENUM?
 * É uma lista fixa de opções permitidas.
 * Serve para garantir que um campo só aceite valores pré-definidos
 * (ex: apenas BAIXA, MEDIA ou ALTA), evitando erros de digitação,
 * valores inválidos e protegendo a integridade dos dados.
 */
public enum Prioridade {
    BAIXA,
    MEDIA,
    ALTA
}
