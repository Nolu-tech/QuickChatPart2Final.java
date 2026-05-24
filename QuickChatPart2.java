/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quickchatpart2;



import java.util.Scanner;



public class QuickChatPart2



{



    public static void main(String[] args)



    {



        Scanner input = new Scanner(System.in);



        // NOTE: Arrays used to store message data



        String[] recipients = new String[100];



        String[] messages = new String[100];



        long[] messageIDs = new long[100];



        String[] messageHashes = new String[100];



        int messageIndex = 0;



        int choice;



        // NOTE: Welcome screen



        System.out.println("Welcome to QuickChat");



        do



        {



            // NOTE: Main menu



            System.out.println("\n1. Send Message");



            System.out.println("2. Show recently sent messages");



            System.out.println("3. Quit");



            System.out.print("Choose an option: ");



            choice = input.nextInt();



            input.nextLine();



            switch(choice)



            {



                case 1:



                    // NOTE: Number of messages



                    System.out.print("How many messages do you want to send? ");



                    int messageCount = input.nextInt();



                    input.nextLine();



                    for(int i = 0; i < messageCount; i++)



                    {



                        // NOTE: Recipient input



                        System.out.print("\nEnter recipient number (0XXXXXXXXX or +27XXXXXXXXX): ");



                        String recipient = input.nextLine();



                        // NOTE: Validate SA number format



                        if(recipient.startsWith("+27"))



                        {



                            if(recipient.length() != 12)



                            {



                                System.out.println("Invalid number. Use +27XXXXXXXXX format.");



                                continue;



                            }



                        }



                        else if(recipient.startsWith("0"))



                        {



                            if(recipient.length() != 10)



                            {



                                System.out.println("Invalid number. Must be 10 digits starting with 0.");



                                continue;



                            }



                        }



                        else



                        {



                            System.out.println("Invalid number format.");



                            continue;



                        }



                        // NOTE: Message input



                        System.out.print("Enter message (max 250 characters): ");



                        String message = input.nextLine();



                        if(message.length() > 250)



                        {



                            System.out.println("Message too long! Limit is 250 characters.");



                            continue;



                        }



                        // NOTE: Generate Message ID



                        long messageID =



                                (long)(Math.random() * 9000000000L)



                                + 1000000000L;



                        // NOTE: Create Message Hash



                        String[] words = message.split(" ");



                        String firstWord = words[0];



                        String lastWord = words[words.length - 1];



                        String messageHash =



                                (messageID + "").substring(0, 2)



                                + ":" + (messageIndex + 1)



                                + ":" + firstWord.toUpperCase()



                                + lastWord.toUpperCase();



                        // NOTE: Message options



                        System.out.println("\nChoose message option:");



                        System.out.println("1. Send Message");



                        System.out.println("2. Disregard Message");



                        System.out.println("3. Store Message");



                        int option = input.nextInt();



                        input.nextLine();



                        switch(option)



                        {



                            case 1:



                                recipients[messageIndex] = recipient;



                                messages[messageIndex] = message;



                                messageIDs[messageIndex] = messageID;



                                messageHashes[messageIndex] = messageHash;



                                messageIndex++;



                                System.out.println("\nMessage successfully sent!");



                                System.out.println("Message ID: " + messageID);



                                System.out.println("Message Hash: " + messageHash);



                                break;



                            case 2:



                                System.out.println("Message disregarded.");



                                break;



                            case 3:



                                recipients[messageIndex] = recipient;



                                messages[messageIndex] = message;



                                messageIDs[messageIndex] = messageID;



                                messageHashes[messageIndex] = messageHash;



                                messageIndex++;



                                System.out.println("Message successfully stored.");



                                System.out.println("Message Hash: " + messageHash);



                                break;



                            default:



                                System.out.println("Invalid option.");



                        }



                    }



                    break;



                case 2:



                    // NOTE: Display messages



                    if(messageIndex == 0)



                    {



                        System.out.println("No messages stored yet.");



                    }



                    else



                    {



                        System.out.println("\n--- SENT MESSAGES ---");



                        for(int i = 0; i < messageIndex; i++)



                        {



                            System.out.println("\nMessage " + (i + 1));



                            System.out.println("Recipient: " + recipients[i]);



                            System.out.println("Message: " + messages[i]);



                            System.out.println("Message ID: " + messageIDs[i]);



                            System.out.println("Message Hash: " + messageHashes[i]);



                        }



                        System.out.println("\nTotal messages sent: " + messageIndex);



                    }



                    break;



                case 3:



                    System.out.println("Goodbye!");



                    break;



                default:



                    System.out.println("Invalid option. Try again.");



            }



        }



        while(choice != 3);



    }



}