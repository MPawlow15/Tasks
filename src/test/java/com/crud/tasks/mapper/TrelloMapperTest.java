package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    TrelloMapper trelloMapper;

    @Test
    public void shouldMapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        trelloBoardDto.add(new TrelloBoardDto("1", "Test board", new ArrayList<>()));

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDto);

        //Then
        assertEquals(1, trelloBoards.size());
        assertEquals("1", trelloBoards.get(0).getId());
        assertEquals("Test board", trelloBoards.get(0).getName());
    }

    @Test
    public void shouldMapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "Test board", new ArrayList<>()));

        //When
        List<TrelloBoardDto> trelloBoardDto = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals(1, trelloBoardDto.size());
        assertEquals("1", trelloBoardDto.get(0).getId());
        assertEquals("Test board", trelloBoardDto.get(0).getName());
    }

    @Test
    public void shouldMapToList() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1", "Test list", false));

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDto);

        //Then
        assertEquals(1, trelloLists.size());
        assertEquals("1", trelloLists.get(0).getId());
        assertEquals("Test list", trelloLists.get(0).getName());
        assertEquals(false, trelloLists.get(0).isClosed());
    }

    @Test
    public void shouldMapToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "Test list", false));

        //When
        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(1, trelloListDto.size());
        assertEquals("1", trelloListDto.get(0).getId());
        assertEquals("Test list", trelloListDto.get(0).getName());
        assertEquals(false, trelloListDto.get(0).isClosed());
    }

    @Test
    public void shouldMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Test Card", "Test Description", "top", "1");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("Test Card", trelloCardDto.getName());
        assertEquals("Test Description", trelloCardDto.getDescription());
        assertEquals("top", trelloCardDto.getPos());
        assertEquals("1", trelloCardDto.getListId());
    }

    @Test
    void testmapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "des", "pos", "12");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("12", trelloCard.getListId());
        assertEquals("pos", trelloCard.getPos());
        assertEquals("name", trelloCard.getName());
        assertEquals("des", trelloCard.getDescription());
    }

}
