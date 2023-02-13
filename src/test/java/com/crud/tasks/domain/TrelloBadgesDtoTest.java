package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrelloBadgesDtoTest {
    @Test
    void trelloTest() {
        //Given
        TrelloBadgesDto trelloBadgesDto = new TrelloBadgesDto();
        TrelloAttachmentsByType trelloAttachmentsByType= new TrelloAttachmentsByType();
        TrelloDto trello = new TrelloDto();
        trello.setBoard(1);
        trello.setCard(2);
        trelloAttachmentsByType.setTrello(trello);

        //When
        trelloBadgesDto.setVotes(1);
        trelloBadgesDto.setAttachmentsByType(trelloAttachmentsByType);
        TrelloAttachmentsByType retrievedAttachments = trelloBadgesDto.getAttachmentsByType();
        TrelloDto retrievedTrelloDto = retrievedAttachments.getTrello();
        int retrievedVotes = trelloBadgesDto.getVotes();

        //Then
        assertEquals(1, retrievedTrelloDto.getBoard());
        assertEquals(2, retrievedTrelloDto.getCard());
        assertEquals(1, retrievedVotes);
    }

}